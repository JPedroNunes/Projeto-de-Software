import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Geral{
    
    public static void main(String[] args) {
        ArrayList<Funcionario> funcionarios = new ArrayList();
        ArrayList<Sindicato> sindicato_f = new ArrayList();
        ArrayList<Agenda> dia_do_pagamento = new ArrayList();
        int padrão = 0;
        while(padrão < 3){
            Agenda dia_temp = new Agenda();
            if(padrão == 0){
                dia_temp.setPag("semana 1 sexta");
                dia_do_pagamento.add(dia_temp);
            }
            else if(padrão == 1){
                dia_temp.setPag("semana 2 sexta");
                dia_do_pagamento.add(dia_temp);
            }
            else{
                dia_temp.setPag("mensal $");
                dia_do_pagamento.add(dia_temp);
            }
            padrão+=1;
        }

        // ArrayList<Boolean> removidos = new ArrayList();
        int opção = -1;
        while(opção != 0){
            System.out.println("\n--------Digite o número correspondente a ação!--------\n");
            System.out.println("1 - Cadastrar Funcionário(a)");
            System.out.println("2 - Remover Funcionário(a)");
            System.out.println("3 - Listar Funcionários(as)");
            System.out.println("4 - Cartão de pontos");
            System.out.println("5 - Lançar venda");
            System.out.println("6 - Taxa de serviço");
            System.out.println("7 - Alterar dados do funcionário");
            System.out.println("8 - Fazer pagamento");
            System.out.println("9 - Alteração de agenda");
            System.out.println("10 - Criação de nova agenda");
            System.out.println("0 - sair\n");
            System.out.print("--> ");
            Scanner sc = new Scanner(System.in);
            opção = Integer.parseInt(sc.nextLine());
            
            if(opção == 1){
                // removidos.add(false);
                Funcionario temporário = new Funcionario();
                Sindicato temp = new Sindicato();

                System.out.print("\nNome: ");
                // System.out.print("--> ");
                String nome = sc.nextLine();
                
                System.out.print("\nEndereço: ");
                // System.out.print("--> ");
                String endereço = sc.nextLine();

                System.out.println("\nTem sindicato?");
                String sindicato;
                double taxa = 0.0;
                while(1 > 0){
                    System.out.println("1 - Sim");
                    System.out.println("2 - Não\n");
                    System.out.print("--> ");
                    int op = sc.nextInt();
                    if(op == 1){
                        sindicato = "Sim";
                        System.out.println("\nDigite a taxa fixa:\n");
                        System.out.print("--> ");
                        taxa = sc.nextDouble();
                        temp.add_sindicato((funcionarios.size()+1), sindicato_f.size(), taxa);
                        sindicato_f.add(temp);
                        break;
                    }
                    else if(op == 2){
                        sindicato = "Não";
                        break;
                    }
                    else{
                        System.out.println("\nEntrada inválida, tente novamente.");
                    }
                }

                System.out.println("\nEscolha o tipo de funcionário:");
                String tipo_funcionario;
                String f_commissioned = "Não";
                double porcent = 0.0;
                String diaPaga;
                while(1 > 0){
                    System.out.println("1 - hourly");
                    System.out.println("2 - assalaried\n");
                    System.out.print("--> ");
                    int op = sc.nextInt();

                    if(op == 1){
                        tipo_funcionario = "hourly";
                        diaPaga = "semanal 1 sexta";
                        break;
                    }
                    else if(op == 2){
                        tipo_funcionario = "assalaried";
                        System.out.println("\nEste(a) funcionário(a) terá comissão?");
                        System.out.println("1 - Sim");
                        System.out.println("2 - Não\n");
                        System.out.print("--> ");
                        int aux = sc.nextInt();
                        if(aux == 1){
                            diaPaga = "semanal 2 sexta";
                            f_commissioned = "Sim";
                            System.out.print("\nDigite a porcentagem que ganhará por comissão: ");
                            porcent = sc.nextDouble();
                            
                        }
                        else{
                            diaPaga = "mensal $";
                        }
                        break;
                    }
                    else{
                        System.out.println("\nEntrada Inválida, tente novamente.");
                    }
                }

                double salário = 0.0;
                
                if(tipo_funcionario.equals("hourly")){
                    System.out.println("\nQual o valor a receber por hora?\n");
                    System.out.print("--> ");
                    salário = sc.nextDouble();
                }
                else if(tipo_funcionario.equals("assalaried")){
                    System.out.println("\nQual o valor a receber mensalmente?\n");
                    System.out.print("--> ");
                    salário = sc.nextDouble();
                }
                
                String metodo_pag;
                while(1 > 0){
                    System.out.println("\n\nEscolha o metodo de pagamento:\n");
                    System.out.println("1 - Cheque por correio");
                    System.out.println("2 - Cheque em mãos");
                    System.out.println("3 - Depósito bancário\n");
                    System.out.print("--> ");
                    int aux = sc.nextInt();

                    if(aux == 1){
                        metodo_pag = "Cheque por correio";
                        break;
                    }
                    else if(aux == 2){
                        metodo_pag  = "Cheque em mãos";
                        break;
                    }
                    else if(aux == 3){
                        metodo_pag = "Depótido bancário";
                        break;
                    }
                    else{
                        System.out.println("Tipo inválido");
                    }
                }
                temporário.setMetodoPag(metodo_pag);
                
                temporário.setReg(nome, endereço, sindicato, tipo_funcionario, f_commissioned, salário, porcent);
                temporário.setDia(diaPaga);
                funcionarios.add(temporário);
                

                System.out.println("\nFuncionário criado!\n");
                System.out.println("\n---------Dados do funcionário criádo---------\n");
                System.out.println("ID: "+funcionarios.size());
                funcionarios.get((funcionarios.size()-1)).dados();

            }
            else if(opção == 2){
                System.out.println("\nDigite o ID correspondente ao funcionário:\n");
                System.out.print("--> ");
                int remover = sc.nextInt();
                while(true){
                    System.out.println("\n1 - Conferir dados");
                    System.out.println("2 - Confirmar remoção");
                    System.out.println("3 - Voltar ao menu anterior\n");
                    System.out.print("--> ");

                    int confirm = sc.nextInt();
                    if(confirm == 1){
                        System.out.println("\n---------Dados do funcionário---------\n");
                        System.out.println("ID: "+(remover));
                        funcionarios.get((remover-1)).dados();
                        continue;
                    }
                    else if(confirm == 2){
                        if(funcionarios.get((remover-1)).sindicato.equals("Sim")){
                            int j = 0;
                            while(j < sindicato_f.size()){
                                if((remover-1) == sindicato_f.get(j).funcionario_id){
                                    sindicato_f.remove(j);
                                    break;
                                }
                                j+=1;
                            }
                        }
                        funcionarios.remove((remover-1));
                        
                        System.out.println("\nFuncionário removido com sucesso\n");
                        break;
                    }
                    else if(confirm == 3){
                        break;
                    }
                    else{
                        System.out.println("\nEntrada inválida, tente novamente.");
                    }
                }
            }
            else if(opção == 3){
                int x = 0;
                while(x < funcionarios.size()){
                    System.out.println("\nID: "+ (x+1));
                    funcionarios.get((x)).dados();
                    x++;
                }
            }
            else if(opção == 4){
                while(1 > 0){
                    System.out.print("\nCaso deseje voltar ao menu anterior, digite 0");
                    System.out.print("\nID do funcionário: ");
                    int id_f = sc.nextInt();
                    if((id_f <= funcionarios.size()) && funcionarios.get((id_f-1)).tipo_funcionario.equals("hourly")){
                        System.out.print("\nHora da entrada: ");
                        int hora_entrada = sc.nextInt();

                        System.out.print("\nHora da saída: ");
                        int hora_saída = sc.nextInt();

                        int hora_trabalhada = hora_saída - hora_entrada;
                        
                        Funcionario temporário = funcionarios.get((id_f-1));
                        temporário.setHoras(hora_trabalhada);
                        
                        // funcionarios.remove((id_f-1));
                        funcionarios.set((id_f-1),temporário);

                        break;
                    }
                    else if(id_f == 0){
                        break;
                    }
                    else{
                        System.out.println("\nID não é de um funcionário horista.");
                        System.out.println("Tente novamente.\n");
                    }

                }
            }
            else if(opção == 5){
                System.out.print("\nID do funcionário que vendeu: ");
                int id_f = sc.nextInt();
                if((id_f <= funcionarios.size()) && funcionarios.get((id_f-1)).f_commissioned.equals("Sim")){
                    System.out.print("\nInforme o valor do item vendido: ");
                    double valor_venda = 0.0;
                    valor_venda = sc.nextDouble();
                    valor_venda = valor_venda * (funcionarios.get((id_f-1)).porcent/100);

                    Funcionario temporário = funcionarios.get((id_f-1));
                    temporário.comission_value(valor_venda);
                    
                    // funcionarios.remove((id_f-1));
                    funcionarios.set((id_f-1),temporário);

                }
                
            }
            else if(opção == 6){
                while(1 > 0){
                    System.out.println("\nDigite 0 para sair");
                    int id_s;
                    System.out.println("Digite o ID do funcionário no sindicato: ");
                    id_s = sc.nextInt();
                    if(id_s == 0){
                        break;
                    }
                    else if(id_s <= sindicato_f.size()){
                        double taxa = 0.0;
                        System.out.print("Digite a taxa de serviço: ");
                        taxa = sc.nextDouble();

                        Sindicato temp = sindicato_f.get((id_s-1));
                        temp.serviço(taxa);

                        sindicato_f.set((id_s-1), temp);
                        break;
                    }
                    else{
                        System.out.println("\nID inválido, tente novamente");
                    }
                }
            }
            else if(opção == 7){
                while(1>0){
                    System.out.println("\nDigite 0 para sair");
                    int id_f;
                    System.out.print("\nDigite o ID: ");
                    id_f = sc.nextInt();
                    

                    if(id_f == 0){
                        break;
                    }
                    else if(id_f <= funcionarios.size()){
                        System.out.println("\nO que você deseja alterar?\n");
                        System.out.println("1 - Alterar nome");
                        System.out.println("2 - Alterar endereço");
                        System.out.println("3 - Alterar tipo de funcionário");
                        System.out.println("4 - Alterar metodo de pagamento");
                        System.out.println("5 - Alterar sindicato");
                        System.out.println("6 - Alterar taxa sindical");
                        System.out.println("0 - sair\n");
                        System.out.print("--> ");

                        int info;
                        info = sc.nextInt();

                        sc.nextLine();

                        if(info == 1){
                            Funcionario temporario = funcionarios.get((id_f-1));
                            System.out.println("\nDigite o novo nome:\n");
                            System.out.print("--> ");
                            String temp = sc.nextLine();

                            temporario.setNome(temp);

                            funcionarios.set((id_f-1), temporario);

                            System.out.println("\nNome alterado com sucesso!\n");
                            break;
                        }
                        else if(info == 2){
                            Funcionario temporario = funcionarios.get((id_f-1));
                            System.out.println("\nDigite o novo endereço:\n");
                            System.out.print("--> ");
                            String temp_end = sc.nextLine();

                            temporario.setEndereço(temp_end);

                            funcionarios.set((id_f-1), temporario);

                            System.out.println("\nEndereço alterado com sucesso!\n");
                            break;
                        }
                        else if(info == 3){
                            Funcionario temporario = funcionarios.get((id_f-1));
                            String tipo_func;
                            while(1 > 0){
                                System.out.println("\nEscolha o novo tipo de funcionario:\n");
                                System.out.println("1 - Hourly");
                                System.out.println("2 - assalaried\n");
                                System.out.print("--> ");
                                int temp = sc.nextInt();

                                if(temp == 1){
                                    tipo_func = "hourly";
                                    break;
                                }
                                else if(temp == 2){
                                    tipo_func = "assalaried";
                                    break;
                                }
                                else{
                                    System.out.println("Tipo inválido");
                                }
                            }
                            temporario.setTipoFun(tipo_func);

                            funcionarios.set((id_f-1), temporario);

                            System.out.println("\nTipo de funcionário alterado com sucesso!\n");
                            break;
                        }
                        else if(info == 4){
                            Funcionario temporario = funcionarios.get((id_f-1));
                            String metodo;
                            while(1 > 0){
                                System.out.println("\nEscolha o metodo de pagamento:\n");
                                System.out.println("1 - Cheque por correio");
                                System.out.println("2 - Cheque em mãos");
                                System.out.println("3 - Depósito bancário\n");
                                System.out.print("--> ");
                                int temp = sc.nextInt();

                                if(temp == 1){
                                    metodo = "Cheque por correio";
                                    break;
                                }
                                else if(temp == 2){
                                    metodo  = "Cheque em mãos";
                                    break;
                                }
                                else if(temp == 3){
                                    metodo = "Depótido bancário";
                                    break;
                                }
                                else{
                                    System.out.println("Tipo inválido");
                                }
                            }
                            temporario.setMetodoPag(metodo);

                            funcionarios.set((id_f-1), temporario);

                            System.out.println("\nSindicato alterado com sucesso!\n");
                            break;
                        }
                        else if(info == 5){
                            Funcionario temporario = funcionarios.get((id_f-1));
                            String sind;
                            while(1 > 0){
                                System.out.println("\nEscolha se terá sindicato:\n");
                                System.out.println("1 - Sim");
                                System.out.println("2 - Não\n");
                                System.out.print("--> ");
                                int temp = sc.nextInt();

                                if(temp == 1){
                                    sind = "Sim";
                                    break;
                                }
                                else if(temp == 2){
                                    sind  = "Não";
                                    break;
                                }
                                else{
                                    System.out.println("Tipo inválido");
                                }
                            }
                            temporario.setSindicato(sind);

                            funcionarios.set((id_f-1), temporario);

                            System.out.println("\nSindicato alterado com sucesso!\n");
                            break;
                        }
                        else if(info == 6){
                            int x = 0;
                            while(x < sindicato_f.size()){
                                if(id_f == sindicato_f.get(x).funcionario_id){
                                    break;
                                }
                                x += 1;
                            }
                            Sindicato temporario = sindicato_f.get(x);
                            System.out.println("\nDigite a nova taxa:\n");
                            System.out.print("--> ");
                            double taxa = 0.0;
                            taxa = sc.nextDouble();

                            temporario.setTaxaFixa(taxa);

                            sindicato_f.set(x, temporario);

                            System.out.println("\nTaxa alterada com sucesso!\n");
                            break;
                        }
                        else if(info == 7){
                            Funcionario temporario = funcionarios.get((id_f-1));
                            System.out.println("\nDigite o novo salário:\n");
                            System.out.print("--> ");
                            double temp = sc.nextDouble();

                            temporario.setSalario(temp);

                            funcionarios.set((id_f-1), temporario);

                            System.out.println("\nSalario alterado com sucesso!\n");
                            break;
                        }
                        else if(info == 0){
                            break;
                        }
                        else{
                            System.out.println("Opção não está dentre as listadas!");
                        }
                    }
                    else{
                        System.out.println("ID inválido!");
                    }
                }
            }
            else if(opção == 8){

                System.out.println("\nFuncionarios pagos:\n");
                LocalDate today = LocalDate.now();
                int data_hoje = today.getDayOfMonth();
                String pagamento_hoje = "mensal " + String.valueOf(data_hoje);
                int i = 0;
                while(i < funcionarios.size()){
                    if(pagamento_hoje.equals(funcionarios.get(i).dia_pagamento)){
                        System.out.print("ID: "+(i+1)+"; Valor recebido: ");
                        if(funcionarios.get(i).tipo_funcionario.equals("hourly")){
                            double soma = ((funcionarios.get(i).salário*funcionarios.get(i).horas)+((funcionarios.get(i).salário*1.5)*funcionarios.get(i).hora_extra));
                            if(funcionarios.get(i).sindicato.equals("Sim")){
                                int j = 0;
                                while(j < sindicato_f.size()){
                                    if(i == sindicato_f.get(j).funcionario_id){
                                        soma = (soma - (sindicato_f.get(j).taxa_fixa + sindicato_f.get(j).taxa_de_serviço));

                                        Sindicato s_t = sindicato_f.get(j);
                                        s_t.zerarTaxa();
                                        sindicato_f.set(j, s_t);
                                        break;
                                    }
                                    j+=1;
                                }
                            }
                            System.out.println(soma);
                            Funcionario f_t = funcionarios.get(i);
                            f_t.zerarHora();
                            funcionarios.set(i, f_t);
                        }
                        else if(funcionarios.get(i).tipo_funcionario.equals("assalaried")){
                            if(funcionarios.get(i).f_commissioned.equals("Sim")){
                                // System.out.println(funcionarios.get(i).salário+"+"+funcionarios.get(i).salário_extra);
                                double soma = (funcionarios.get(i).salário + funcionarios.get(i).salário_extra);
                                if(funcionarios.get(i).sindicato.equals("Sim")){
                                    int j = 0;
                                    while(j < sindicato_f.size()){
                                        if(i == sindicato_f.get(j).funcionario_id){
                                            soma = (soma - (sindicato_f.get(j).taxa_fixa + sindicato_f.get(j).taxa_de_serviço));
    
                                            Sindicato s_t = sindicato_f.get(j);
                                            s_t.zerarTaxa();
                                            sindicato_f.set(j, s_t);
                                            break;
                                        }
                                        j+=1;
                                    }
                                }
                                System.out.println(soma);
                                Funcionario f_t = funcionarios.get(i);
                                f_t.comission_value(0);
                                funcionarios.set(i, f_t);
                            }
                            else{
                                double soma = funcionarios.get(i).salário;
                                if(funcionarios.get(i).sindicato.equals("Sim")){
                                    int j = 0;
                                    while(j < sindicato_f.size()){
                                        if(i == sindicato_f.get(j).funcionario_id){
                                            soma = (soma - (sindicato_f.get(j).taxa_fixa + sindicato_f.get(j).taxa_de_serviço));
    
                                            Sindicato s_t = sindicato_f.get(j);
                                            s_t.zerarTaxa();
                                            sindicato_f.set(j, s_t);
                                            break;
                                        }
                                        j+=1;
                                    }
                                }
                                System.out.println(soma);
                            }
                        }
                    }
                    i+=1;
                }

                i = 0;
                int semana = Calendar.WEEK_OF_MONTH;
                if(semana % 2 == 0){
                    semana = 2;
                }
                else{
                    semana = 1;
                }
                String name_dia = today.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.getDefault());
                if(name_dia.equals("dom")){
                    name_dia = "domingo";
                }
                else if(name_dia.equals("seg")){
                    name_dia = "segunda";
                }
                else if(name_dia.equals("ter")){
                    name_dia = "terça";
                }
                else if(name_dia.equals("qua")){
                    name_dia = "quarta";
                }
                else if(name_dia.equals("qui")){
                    name_dia = "quinta";
                }
                else if(name_dia.equals("sex")){
                    name_dia = "sexta";
                }
                else if(name_dia.equals("sab")){
                    name_dia = "sábado";
                }
                pagamento_hoje = "semanal " + String.valueOf(semana) + " " + name_dia;
                // System.out.println(pagamento_hoje);

                while(i < funcionarios.size()){
                    if(pagamento_hoje.equals(funcionarios.get(i).dia_pagamento)){
                        System.out.print("ID: "+(i+1)+"; Valor recebido: ");
                        if(funcionarios.get(i).tipo_funcionario.equals("hourly")){
                            double soma = ((funcionarios.get(i).salário*funcionarios.get(i).horas)+((funcionarios.get(i).salário*1.5)*funcionarios.get(i).hora_extra));
                            if(funcionarios.get(i).sindicato.equals("Sim")){
                                int j = 0;
                                while(j < sindicato_f.size()){
                                    if(i == sindicato_f.get(j).funcionario_id){
                                        soma = (soma - (sindicato_f.get(j).taxa_fixa + sindicato_f.get(j).taxa_de_serviço));

                                        Sindicato s_t = sindicato_f.get(j);
                                        s_t.zerarTaxa();
                                        sindicato_f.set(j, s_t);
                                        break;
                                    }
                                    j+=1;
                                }
                            }
                            System.out.println(soma);
                            Funcionario f_t = funcionarios.get(i);
                            f_t.zerarHora();
                            funcionarios.set(i, f_t);
                        }
                        else if(funcionarios.get(i).tipo_funcionario.equals("assalaried")){
                            if(funcionarios.get(i).f_commissioned.equals("Sim")){
                                // System.out.println(funcionarios.get(i).salário+"+"+funcionarios.get(i).salário_extra);
                                double soma = (funcionarios.get(i).salário + funcionarios.get(i).salário_extra);
                                if(funcionarios.get(i).sindicato.equals("Sim")){
                                    int j = 0;
                                    while(j < sindicato_f.size()){
                                        if(i == sindicato_f.get(j).funcionario_id){
                                            soma = (soma - (sindicato_f.get(j).taxa_fixa + sindicato_f.get(j).taxa_de_serviço));
    
                                            Sindicato s_t = sindicato_f.get(j);
                                            s_t.zerarTaxa();
                                            sindicato_f.set(j, s_t);
                                            break;
                                        }
                                        j+=1;
                                    }
                                }
                                System.out.println(soma);
                                Funcionario f_t = funcionarios.get(i);
                                f_t.comission_value(0);
                                funcionarios.set(i, f_t);
                            }
                            else{
                                double soma = funcionarios.get(i).salário;
                                if(funcionarios.get(i).sindicato.equals("Sim")){
                                    int j = 0;
                                    while(j < sindicato_f.size()){
                                        if(i == sindicato_f.get(j).funcionario_id){
                                            soma = (soma - (sindicato_f.get(j).taxa_fixa + sindicato_f.get(j).taxa_de_serviço));
    
                                            Sindicato s_t = sindicato_f.get(j);
                                            s_t.zerarTaxa();
                                            sindicato_f.set(j, s_t);
                                            break;
                                        }
                                        j+=1;
                                    }
                                }
                                System.out.println(soma);
                            }
                        }
                    }
                    i+=1;
                }

                String final_mes = "false";
                if(today.getDayOfMonth() == today.lengthOfMonth() - 2) {
                    if(today.getDayOfWeek().equals("FRIDAY")){
                      final_mes = "true";
                    }
                }

                if(today.getDayOfMonth() == today.lengthOfMonth())
                {
                    if(!(today.getDayOfWeek().equals("SATURDAY")) && !(today.getDayOfWeek().equals("SUNDAY")))
                    {
                        final_mes = "true";
                    }
                }
                if(final_mes.equals("true"))
                {
                    i = 0;
                    while(i < funcionarios.size()){
                        if(pagamento_hoje.equals(funcionarios.get(i).dia_pagamento)){
                            System.out.print("ID: "+(i+1)+"; Valor recebido: ");
                            if(funcionarios.get(i).tipo_funcionario.equals("hourly")){
                                double soma = ((funcionarios.get(i).salário*funcionarios.get(i).horas)+((funcionarios.get(i).salário*1.5)*funcionarios.get(i).hora_extra));
                                if(funcionarios.get(i).sindicato.equals("Sim")){
                                    int j = 0;
                                    while(j < sindicato_f.size()){
                                        if(i == sindicato_f.get(j).funcionario_id){
                                            soma = (soma - (sindicato_f.get(j).taxa_fixa + sindicato_f.get(j).taxa_de_serviço));
    
                                            Sindicato s_t = sindicato_f.get(j);
                                            s_t.zerarTaxa();
                                            sindicato_f.set(j, s_t);
                                            break;
                                        }
                                        j+=1;
                                    }
                                }
                                System.out.println(soma);
                                Funcionario f_t = funcionarios.get(i);
                                f_t.zerarHora();
                                funcionarios.set(i, f_t);
                            }
                            else if(funcionarios.get(i).tipo_funcionario.equals("assalaried")){
                                if(funcionarios.get(i).f_commissioned.equals("Sim")){
                                    // System.out.println(funcionarios.get(i).salário+"+"+funcionarios.get(i).salário_extra);
                                    double soma = (funcionarios.get(i).salário + funcionarios.get(i).salário_extra);
                                    if(funcionarios.get(i).sindicato.equals("Sim")){
                                        int j = 0;
                                        while(j < sindicato_f.size()){
                                            if(i == sindicato_f.get(j).funcionario_id){
                                                soma = (soma - (sindicato_f.get(j).taxa_fixa + sindicato_f.get(j).taxa_de_serviço));
        
                                                Sindicato s_t = sindicato_f.get(j);
                                                s_t.zerarTaxa();
                                                sindicato_f.set(j, s_t);
                                                break;
                                            }
                                            j+=1;
                                        }
                                    }
                                    System.out.println(soma);
                                    Funcionario f_t = funcionarios.get(i);
                                    f_t.comission_value(0);
                                    funcionarios.set(i, f_t);
                                }
                                else{
                                    double soma = funcionarios.get(i).salário;
                                    if(funcionarios.get(i).sindicato.equals("Sim")){
                                        int j = 0;
                                        while(j < sindicato_f.size()){
                                            if(i == sindicato_f.get(j).funcionario_id){
                                                soma = (soma - (sindicato_f.get(j).taxa_fixa + sindicato_f.get(j).taxa_de_serviço));
        
                                                Sindicato s_t = sindicato_f.get(j);
                                                s_t.zerarTaxa();
                                                sindicato_f.set(j, s_t);
                                                break;
                                            }
                                            j+=1;
                                        }
                                    }
                                    System.out.println(soma);
                                }
                            }
                        }
                        i+=1;
                    }
                }


            }
            else if(opção == 9){
                int id_f;
                while(1 > 0){
                    System.out.println("\nDigite o id do funcionário: ");
                    id_f = sc.nextInt();
                    if(id_f <= funcionarios.size() && id_f >= 1){
                        break;
                    }
                    else{
                        System.out.println("Funcionario inexistente\n");
                    }
                }
                System.out.println("\nAgenda:\n");
                int i = 0;
                while(i < dia_do_pagamento.size()){
                    System.out.println((i+1)+" - "+dia_do_pagamento.get(i).dia_pagamento);
                    i+=1;
                }
                while(1 > 0){
                    System.out.print("\nEscolha uma das opções anteriores: ");
                    i = sc.nextInt();
                    if(i <= dia_do_pagamento.size()){
                        Funcionario f_temp = new Funcionario();
                        f_temp = funcionarios.get((id_f-1));
                        f_temp.setDia(dia_do_pagamento.get((i-1)).dia_pagamento);

                        funcionarios.set((id_f-1), f_temp);
                        break;
                    }
                    else{
                        System.out.println("\nOpção inválida!\n");
                    }
                }
            }
            else if(opção == 10){
                Agenda dia_temp = new Agenda();
                String dia_def;
                while(1 > 0){
                    System.out.println("\nEscolha uma opção:");
                    System.out.println("1 - semanal");
                    System.out.println("2 - mensal\n");
                    System.out.print("--> ");

                    int aux = sc.nextInt();
                    int aux2;
                    int dia;
                    
                    if(aux == 1){
                        while(1>0){
                            System.out.println("\nDigite a cada quantas semanas:");
                            System.out.println("1 - A cada 1 semana");
                            System.out.println("2 - A cada 2 semanas\n");
                            System.out.print("--> ");
                            aux2 = sc.nextInt();
                            if(aux2 == 1){
                                while(1 > 0){
                                    System.out.println("\nEscolha o dia:");
                                    System.out.println("1 - domingo");
                                    System.out.println("2 - segunda");
                                    System.out.println("3 - terça");
                                    System.out.println("4 - quarta");
                                    System.out.println("5 - quinta");
                                    System.out.println("6 - sexta");
                                    System.out.println("7 - sábado\n");
                                    System.out.print("--> ");
                                    dia = sc.nextInt();
                                    if(dia == 1){
                                        dia_def = "semanal 1 domingo";
                                        break;
                                    }
                                    else if(dia == 2){
                                        dia_def = "semanal 1 segunda";
                                        break;
                                    }
                                    else if(dia == 3){
                                        dia_def = "semanal 1 terça";
                                        break;
                                    }
                                    else if(dia == 4){
                                        dia_def = "semanal 1 quarta";
                                        break;
                                    }
                                    else if(dia == 5){
                                        dia_def = "semanal 1 quinta";
                                        break;
                                    }   
                                    else if(dia == 6){
                                        dia_def = "semanal 1 sexta";
                                        break;
                                    }
                                    else if(dia == 7){
                                        dia_def = "semanal 1 sábado";
                                        break;
                                    }
                                    else{
                                        System.out.println("\nOpção inválida!");
                                    }
                                }
                                break;
                            }
                            else if(aux2 == 2){
                                while(1 > 0){
                                    System.out.println("\nEscolha o dia:");
                                    System.out.println("1 - domingo");
                                    System.out.println("2 - segunda");
                                    System.out.println("3 - terça");
                                    System.out.println("4 - quarta");
                                    System.out.println("5 - quinta");
                                    System.out.println("6 - sexta");
                                    System.out.println("7 - sábado\n");
                                    System.out.print("--> ");
                                    dia = sc.nextInt();
                                    if(dia == 1){
                                        dia_def = "semanal 2 domingo";
                                        break;
                                    }
                                    else if(dia == 2){
                                        dia_def = "semanal 2 segunda";
                                        break;
                                    }
                                    else if(dia == 3){
                                        dia_def = "semanal 2 terça";
                                        break;
                                    }
                                    else if(dia == 4){
                                        dia_def = "semanal 2 quarta";
                                        break;
                                    }
                                    else if(dia == 5){
                                        dia_def = "semanal 2 quinta";
                                        break;
                                    }   
                                    else if(dia == 6){
                                        dia_def = "semanal 2 sexta";
                                        break;
                                    }
                                    else if(dia == 7){
                                        dia_def = "semanal 2 sábado";
                                        break;
                                    }
                                    else{
                                        System.out.println("\nOpção inválida!");
                                    }
                                }
                                break;
                            }
                            else{
                                System.out.println("\nOpção inexistente!\n");
                            }
                            
                        }
                        break;
                    }
                    else if(aux == 2){
                        while(1>0){
                            System.out.print("\nDigite o dia do mês (1 a 31): ");
                            aux2 = sc.nextInt();
                            if(aux2 < 1 || aux2 > 31){
                                System.out.println("\nDia inexistente!\n");
                                continue;
                            }
                            else{
                                dia_def = "mensal ";
                                String auux2 = Integer.toString(aux2);
                                dia_def = dia_def + auux2;
                                break;
                            }
                        }
                        break;
                    }
                    else{
                        System.out.println("\nOpção inválida!");
                    }
                }
                dia_temp.setPag(dia_def);
                dia_do_pagamento.add(dia_temp);
            }
            else if(opção == 0){
                System.out.println("\nSaindo...");
            }
            else{
                System.out.println("\nEntrada inválida, tente novamente.");
            }
        }
    }
}

public class Agenda{
    String dia_pagamento;

    public void setPag(String dia_pagamento){
        this.dia_pagamento = dia_pagamento;
    }
}

public class Sindicato{
    int funcionario_id;
    int sindicato_id;
    double taxa_fixa;
    double taxa_de_serviço;

    public void add_sindicato(int funcionario_id, int sindicato_id, double taxa_fixa){
        this.funcionario_id = funcionario_id;
        this.sindicato_id = sindicato_id;
        this.taxa_fixa = taxa_fixa;
    }

    public void zerarTaxa(){
        this.taxa_de_serviço = 0.0;
    }
    public void serviço(double taxa_de_serviço){
        this.taxa_de_serviço += taxa_de_serviço;
    }

    public void setTaxaFixa(double taxa_fixa){
        this.taxa_fixa = taxa_fixa;
    }
}

public class Funcionario extends Geral{
    String nome;
    String endereço;
    String sindicato;
    String tipo_funcionario;
    String f_commissioned;
    String metodo_pagamento;
    String dia_pagamento;
    double salário;
    double salário_extra;
    double horas;
    double hora_extra;
    double comissão;
    double porcent;

    public void dados(){
        System.out.println("Nome: "+this.nome);
        System.out.println("Endereço: "+this.endereço);
        System.out.println("Tem sindicato? "+this.sindicato);
        System.out.println("Tipo de funcionario: "+this.tipo_funcionario);
        System.out.println("Tem comissão? "+this.f_commissioned);
        System.out.println("Metodo de recebimento: "+this.metodo_pagamento);
        System.out.println("Dia do pagamento: "+this.dia_pagamento);
        if(this.tipo_funcionario.equals("hourly")){
            System.out.println("Valor ganho por hora: "+this.salário);
            System.out.println("Horas trabalhadas: "+this.horas);
            System.out.println("Horas extras: "+this.hora_extra);
        }
        else if(this.f_commissioned.equals("Sim")){
            System.out.println("Valor ganho por mês: "+this.salário);
            System.out.println("Valor extra ganho no mês: "+this.salário_extra);
        }
        else{
            System.out.println("Valor ganho por mês: "+this.salário);
        }
    }

    public void comission_value(double salário_extra){
        this.salário_extra += salário_extra;
    }

    public void setReg(String nome, String endereço, String sindicato, String tipo_funcionario, String f_commissioned, Double salário, Double porcent){
        this.nome = nome;
        this.endereço = endereço;
        this.sindicato = sindicato;
        this.tipo_funcionario = tipo_funcionario;
        this.f_commissioned = f_commissioned;
        this.salário = salário;
        this.porcent = porcent;
    }

    public void setHoras(double horas){
        if(horas > 8){
            this.hora_extra += horas - 8;
            this.horas += (horas-this.hora_extra);
        }
        else{
            this.horas += horas;
        }
        
    }

    public void zerarHora(){
        this.hora_extra = 0;
        this.horas = 0;
    }

    public void setDia(String dia_pagamento){
        this.dia_pagamento = dia_pagamento;
    }

    public void setComission(double comissão){
        this.comissão = comissão;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEndereço(String endereço){
        this.endereço = endereço;
    }

    public void setTipoFun(String tipo_funcionario){
        this.tipo_funcionario = tipo_funcionario;
    }

    public void setMetodoPag(String metodo_pagamento){
        this.metodo_pagamento = metodo_pagamento;
    }

    public void setSindicato(String sindicato){
        this.sindicato = sindicato;
    }

    public void setSalario(double salario){
        this.salário = salario;
    }
}
