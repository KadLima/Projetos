package Domain;

import dao.ClienteMapDAO;
import dao.IClienteDAO;

import javax.swing.*;


/**
 * Created by Kadson Lima on 04/10/2024
 *
 * @author Kadson Lima
 */

public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null, "Digite 1 para Cadastro, 2 para Consultar, " +
                "3 para Exclusão, 4 para Alteração ou 5 para Sair", "Cadastro", JOptionPane.INFORMATION_MESSAGE);


        while (!isOpcaoValida(opcao)) {
            if ("".equals(opcao)) {
                sair();
            }
            opcao = JOptionPane.showInputDialog(null, "Opção Inválida. Digite 1 para Cadastro, 2 para Consulta, " +
                    "3 para Exclusão, 4 para Alteração ou 5 para Sair", "Mensagem de Erro", JOptionPane.INFORMATION_MESSAGE);
        }


        while (isOpcaoValida(opcao)) {
            if (isOpcaoSair(opcao)) {
                sair();
            } else if (isCadastro(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite os dados do cliente separados por vírgula, " +
                        "conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade, Estado", "Cadastro", JOptionPane.INFORMATION_MESSAGE);

                cadastrar(dados);
            } else if (isConsultar(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite o CPF: ", "Consultar ",
                        JOptionPane.INFORMATION_MESSAGE);

                consultar(dados);
            } else if (isExcluir(opcao)){
                String dados = JOptionPane.showInputDialog(null, "Digite o CPF do Cliente a ser Excluído: ", "Exclusão de Cliente Cadastrado", JOptionPane.INFORMATION_MESSAGE);
                excluir(dados);
            } else if (isAlterar(opcao)){
                String dados = JOptionPane.showInputDialog(null, "Digite o CPF do Cliente a ser alterado: ", "Alteração de Cliente Cadastrado", JOptionPane.INFORMATION_MESSAGE);
                alterar(dados);
            }

            opcao = JOptionPane.showInputDialog(null, "Digite 1 para Cadastro, 2 para Consultar, " +
                    "3 para Exclusão, 4 para Alteração ou 5 para Sair", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }

    }




    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");

        if(dadosSeparados.length == 0 || (dadosSeparados.length == 1 && dadosSeparados[0].trim().isEmpty())){
            JOptionPane.showMessageDialog(null, "Nenhum valor inserido! Por favor, insira os dados solicitados. ", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nome = dadosSeparados.length > 0 ? dadosSeparados[0].trim() : null;
        String cpfStr = dadosSeparados.length > 1 ? dadosSeparados[1].trim() : null;
        String telStr = dadosSeparados.length > 2 ? dadosSeparados[2].trim() : null;

        if (nome == null || nome.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Inserir um nome é Obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cpfStr == null || nome.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Inserir um CPF é Obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (telStr == null || nome.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Inserir um Telefone é Obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Long cpf;
        Long tel;
        try {
            cpf = Long.valueOf(cpfStr);
            tel = Long.valueOf(telStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O Valor do CPF e do Telefone devem ser Númericos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String end = dadosSeparados.length > 3 ? dadosSeparados[3].trim() : null;
        Integer numero = dadosSeparados.length > 4 ? Integer.valueOf(dadosSeparados[4].trim()) : null;
        String cidade = dadosSeparados.length > 5 ? dadosSeparados[5].trim() : null;
        String estado = dadosSeparados.length > 6 ? dadosSeparados[6].trim() : null;

        Cliente cliente = new Cliente(nome, cpfStr, telStr, end, numero != null ? String.valueOf(numero) : null, cidade , estado);

        Boolean isCadastrado = iClienteDAO.cadastrar(cliente);

        if (isCadastrado) {
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso! ", "Cadastro Efetuado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente já Cadastrado ", "Cadastro Não Realizado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void consultar(String dados) {

        if(dados == null || dados.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "CPF não pode ser vazio! ", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!dados.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Por favor, insira apenas números para o CPF. ", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Cliente Encontrado com Sucesso!  " + cliente.toString(), "Busca Efetuada", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente com o CPF: " + dados + " Não Encontrado:  ", "Busca Mal Sucedida", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static void excluir(String dados) {
        if (dados == null || dados.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "CPF não pode ser vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
        }

        if(!dados.matches("\\d+")){
            JOptionPane.showMessageDialog(null, "Por favor, insira apenas números para o CPF. ", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Long cpf = Long.parseLong(dados);
        Cliente cliente = iClienteDAO.consultar(cpf);
        if(cliente == null){
            JOptionPane.showMessageDialog(null, "Cliente não encontrado! ", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        iClienteDAO.excluir(cpf);
        JOptionPane.showMessageDialog(null, "Cliente excluído com Sucesso", "Exclusão bem Sucedida", JOptionPane.INFORMATION_MESSAGE);

    }

    private static void alterar(String dados){
        if(dados == null || dados.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "CPF Não pode ser vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(!dados.matches("\\d+")){
            JOptionPane.showMessageDialog(null, "Por favor, insira apenas números para o CPF. ", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
        if(cliente != null){
            String novosDados = JOptionPane.showInputDialog(null, "Informe os novos dados do Cliente conforme exemplo: Nome, (NÃO PRECISA INSERIR O CPF NOVAMENTE) Telefone, Endereço, Número, Cidade, Estado: ", "Alteração de Cliente Cadastrado", JOptionPane.INFORMATION_MESSAGE);
            String[] dadosSeparados = novosDados.split(",");
            try{
                cliente.setNumero(Integer.parseInt(dadosSeparados[3].trim()));
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "O Campo Número deve conter apenas números. ", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (dadosSeparados.length < 6){
                JOptionPane.showMessageDialog(null, "Informações incompletas para alteração. ", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            cliente.setNome(dadosSeparados[0].trim());
            cliente.setTel(Long.valueOf(dadosSeparados[1].trim()));
            cliente.setEnd(dadosSeparados[2].trim());
            cliente.setNumero(Integer.valueOf(dadosSeparados[3].trim()));
            cliente.setCidade(dadosSeparados[4].trim());
            cliente.setEstado(dadosSeparados[5].trim());

            iClienteDAO.alterar(cliente);

            JOptionPane.showMessageDialog(null, "Cliente alterado com Sucesso! ", "Alteração Concluída", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "O CPF informado não foi encontrado. ", "Erro", JOptionPane.ERROR_MESSAGE );
        }
    }

    private static boolean isCadastro(String opcao) {
        if ("1".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static boolean isConsultar(String opcao) {
        if ("2".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static boolean isAlterar(String opcao) {
        return "4".equals(opcao);
    }

    private static boolean isExcluir(String opcao) {
        return "3".equals(opcao);
    }

    private static boolean isOpcaoSair(String opcao) {
        if ("5".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Saindo do Programa: ", "Sair", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoValida(String opcao) {
        if ("1".equals(opcao) || "2".equals(opcao)
                || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao)) {
            return true;
        }
        return false;
    }

}
