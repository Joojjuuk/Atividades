package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import model.Boleto;

public class Controller {
    private List<Boleto> listaBoletos = new ArrayList<Boleto>();
    private boolean processado = false;
    private int maiorAtraso = 0;
    private int menorAtraso = 10000;
    private int mediaAtraso = 0;
    private double vlrTotalBoletos = 0;
    private double vlrTotalMultas = 0;
    private double vlrTotalJuros = 0;

    private final double txMulta = 2;
    private final double txJurosMes = 1.2;

    // getters da classe
    public Boleto[] getListaBoletos() {
        return listaBoletos.toArray(new Boleto[0]);
    }

    public boolean isProcessado() {
        return processado;
    }

    public void setProcessado(boolean processado) {
        this.processado = processado;
    }

    public int getMaiorAtraso() {
        return maiorAtraso;
    }

    public int getMenorAtraso() {
        return menorAtraso;
    }

    public int getMediaAtraso() {
        return mediaAtraso;
    }

    public double getVlrTotalBoletos() {
        return vlrTotalBoletos;
    }

    public double getVlrTotalMultas() {
        return vlrTotalMultas;
    }

    public double getVlrTotalJuros() {
        return vlrTotalJuros;
    }

    public int getQtdeBoletos() {
        return this.listaBoletos.size();
    }

    public String getSummary() {
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("R$ #,##0.00");
        String mensagem = "Foram lidos " + this.getQtdeBoletos() + " boletos \n";
        mensagem += "O valor total dos boletos é " + df.format(vlrTotalBoletos) + "\n";

        if (this.isProcessado()) {
            mensagem += "O maior atraso em dias é de " + maiorAtraso + " dias\n";
            mensagem += "O menor atraso em dias é de " + menorAtraso + " dias\n";
            mensagem += "A média de dias atrasados é de " + mediaAtraso + " dias\n";
            mensagem += "O valor total de multas é " + df.format(vlrTotalMultas) + "\n";
            mensagem += "O valor total de juros é " + df.format(vlrTotalJuros);
        }
        return mensagem;
    }

    public void lerArquivoBoletos(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            resetaVars(); // Reseta as variáveis antes de ler o arquivo

            String linha;
            br.readLine(); // Ignora a primeira linha (cabeçalho)
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";");
                String codigo = campos[0];
                String pagador = campos[1];
                int ano = Integer.parseInt(campos[2]);
                int mes = Integer.parseInt(campos[3]) - 1; // Meses em Calendar são baseados em zero
                int dia = Integer.parseInt(campos[4]);
                double valor = Double.parseDouble(campos[5]);

                Calendar dataVenc = Calendar.getInstance();
                dataVenc.set(ano, mes, dia);

                Boleto boleto = new Boleto(codigo, pagador, dataVenc, valor);
                listaBoletos.add(boleto);
                vlrTotalBoletos += valor;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public void processarBoletos() {
        resetaVars(); // Reseta as variáveis antes de processar os boletos

        double taxaMulta = txMulta / 100; // 2% de multa
        double taxaJurosDia = (txJurosMes / 30) / 100; // 1.2% ao mês dividido por 30 dias para obter a taxa diária

        for (Boleto boleto : listaBoletos) {
            int diasAtraso = boleto.getDiasAtraso();
            double valorDocumento = boleto.getVlrDocto();

            // Calcula multa (2% do valor do documento)
            double vlrMulta = valorDocumento * taxaMulta;
            boleto.setVlrMulta(vlrMulta);
            vlrTotalMultas += vlrMulta;

            // Calcula juros (1.2% ao mês dividido por 30 dias * dias de atraso)
            double vlrJuros = valorDocumento * taxaJurosDia * diasAtraso;
            boleto.setVlrJuros(vlrJuros);
            vlrTotalJuros += vlrJuros;

            // Atualiza maior e menor atraso
            if (diasAtraso > maiorAtraso) {
                maiorAtraso = diasAtraso;
            }
            if (diasAtraso < menorAtraso) {
                menorAtraso = diasAtraso;
            }
            // Acumula para calcular a média de atraso
            mediaAtraso += diasAtraso;
        }

        // Calcula média de atraso, se houver boletos na lista
        if (!listaBoletos.isEmpty()) {
            mediaAtraso /= listaBoletos.size();
        }

        processado = true;
    }

    public void salvarArquivoBoletos(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write("Codigo;NomeDevedor;Vencimento;DiasAtraso;ValorDocto;VlrMulta;VlrJuros");
            bw.newLine();

            for (Boleto boleto : listaBoletos) {
                bw.write(boleto.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    public void resetaVars() {
        maiorAtraso = 0;
        menorAtraso = 10000;
        mediaAtraso = 0;
        vlrTotalMultas = 0;
        vlrTotalJuros = 0;
    }
}
