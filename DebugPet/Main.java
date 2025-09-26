import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Tutor> tutores = new ArrayList<>();
    private static ArrayList<Pet> pets = new ArrayList<>();
    private static ArrayList<Servico> servicos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            mensagemInicial();

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarTutor();
                    break;
                case 2:
                    cadastrarPet();
                    break;
                case 3:
                    cadastrarServico();
                    break;
                case 4:
                    listarTutores();
                    break;
                case 5:
                    listarPets();
                    break;
                case 6:
                    limparTela();
                    listarServicos();
                    break;
                case 7:
                    agendarServico();
                    break;
                case 0:
                    System.out.println("Obrigado por utilizar nosso sistema!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        
        scanner.close();
    }

    private static void cadastrarTutor() {
        limparTela();
        System.out.println("\n=== Cadastro de Tutor ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        Tutor tutor = new Tutor(nome, cpf, email, telefone, idade, endereco, new ArrayList<>(), new ArrayList<>());
        tutores.add(tutor);
        System.out.println("Tutor cadastrado com sucesso!");
    }

    private static void cadastrarPet() {
        limparTela();
        if (tutores.isEmpty()) {
            System.out.println("É necessário cadastrar um tutor primeiro!");
            return;
        }

        System.out.println("\n=== Cadastro de Pet ===");
        Pet pet = new Pet();
        
        System.out.print("Nome: ");
        pet.setNome(scanner.nextLine());
        System.out.print("Raça: ");
        pet.setRaca(scanner.nextLine());
        
        String sexo;
        do {
            System.out.print("Sexo (M/F): ");
            sexo = scanner.nextLine().toUpperCase();
            if (!sexo.equals("M") && !sexo.equals("F")) {
                System.out.println("Por favor, digite M para masculino ou F para feminino.");
            }
        } while (!sexo.equals("M") && !sexo.equals("F"));
        pet.setSexo(sexo);

        System.out.print("Idade: ");
        pet.setIdade(scanner.nextLine());
        System.out.print("Peso: ");
        pet.setPeso(scanner.nextDouble());
        scanner.nextLine();

        System.out.println("\nTutores disponíveis:");
        for (int i = 0; i < tutores.size(); i++) {
            System.out.println(i + " - " + tutores.get(i).getNome());
        }
        System.out.print("Selecione o tutor (número): ");
        int tutorIndex = scanner.nextInt();
        scanner.nextLine();

        while (true) {
            if (tutorIndex >= 0 && tutorIndex < tutores.size()) {
                Tutor tutor = tutores.get(tutorIndex);
                pet.setTutor(tutor);
                tutor.addPet(pet);
                pets.add(pet);
                System.out.println("Pet cadastrado com sucesso!");
                break;
            } else {
                System.out.println("Tutor inválido! Tente novamente.");
                System.out.print("Selecione o tutor (número): ");
                tutorIndex = scanner.nextInt();
                scanner.nextLine();
            }
        }
    }

    private static void cadastrarServico() {
        limparTela();
        System.out.println("\n=== Cadastro de Serviço ===");
        Servico servico = new Servico();
        System.out.print("Descrição: ");
        servico.setDescricao(scanner.nextLine());
        System.out.print("Valor: ");
        servico.setValor(scanner.nextDouble());
        scanner.nextLine();
        servicos.add(servico);
        System.out.println("Serviço cadastrado com sucesso!");
    }

    private static void listarTutores() {
        limparTela();
        System.out.println("\n=== Lista de Tutores ===");
        if (tutores.isEmpty()) {
            System.out.println("Nenhum tutor cadastrado.");
            return;
        }
        for (Tutor tutor : tutores) {
            System.out.println("Nome: " + tutor.getNome());
            System.out.println("Telefone: " + tutor.getTelefone());
            System.out.println("CPF: " + tutor.getCpf());
            System.out.println("Email: " + tutor.getEmail());
            System.out.println("Idade: " + tutor.getIdade());
            System.out.println("Endereço: " + tutor.getEndereco());
            System.out.println("--------------------");
        }
    }

    private static void listarPets() {
        limparTela();
        System.out.println("\n=== Lista de Pets ===");
        if (pets.isEmpty()) {
            System.out.println("Nenhum pet cadastrado.");
            return;
        }
        for (Pet pet : pets) {
            System.out.println("Nome: " + pet.getNome());
            System.out.println("Idade: " + pet.getIdade());
            System.out.println("Peso: " + pet.getPeso());
            System.out.println("Sexo: " + pet.getSexo());
            System.out.println("Raça: " + pet.getRaca());
            System.out.println("Tutor: " + (pet.getTutor() != null ? pet.getTutor().getNome() : "Sem tutor"));
            boolean temServico = false;
            for (Servico servico : servicos) {
                if (servico.getPet() != null && servico.getPet().equals(pet)) {
                    if (!temServico) {
                        System.out.println("Serviços Agendados:");
                        temServico = true;
                    }
                    System.out.println("  - " + servico.getDescricao() + 
                                     " (R$ " + servico.getValor() + ")" +
                                     " | Data: " + servico.getData());
                }
            }
            if (!temServico) {
                System.out.println("Sem serviços agendados");
            }
            System.out.println("--------------------");
        }
    }
    private static void listarServicos() {
        System.out.println("\n=== Lista de Serviços ===");
        if (servicos.isEmpty()) {
            System.out.println("Nenhum serviço cadastrado.");
            return;
        }

        for (int i = 0; i < servicos.size(); i++) {
            Servico servico = servicos.get(i);
            System.out.println(i + " - " + servico.getDescricao() + " (R$ " + servico.getValor() + ")");
        }
    }

    private static void agendarServico() {
        limparTela();
        if (pets.isEmpty() || servicos.isEmpty()) {
            System.out.println("É necessário ter pets e serviços cadastrados para agendar um serviço!");
            return;
        }

        System.out.println("\n=== Agendamento de Serviço ===");
        
        System.out.println("\nPets disponíveis:");
        for (int i = 0; i < pets.size(); i++) {
            Pet pet = pets.get(i);
            System.out.println(i + " - " + pet.getNome() + " (Tutor: " + 
                (pet.getTutor() != null ? pet.getTutor().getNome() : "Sem tutor") + ")");
        }

        System.out.print("Selecione o pet (número): ");
        int petIndex = scanner.nextInt();
        scanner.nextLine();

        while (true) {
            if (petIndex >= 0 && petIndex < pets.size()) {
                break;
            } else {
                System.out.println("Por favor, digite um número válido.");
                System.out.println("\nPets disponíveis:");
                for (int i = 0; i < pets.size(); i++) {
                    Pet pet = pets.get(i);
                    System.out.println(i + " - " + pet.getNome() + " (Tutor: " + 
                    (pet.getTutor() != null ? pet.getTutor().getNome() : "Sem tutor") + ")");
                }

                System.out.print("Selecione o pet (número): ");
                petIndex = scanner.nextInt();
                scanner.nextLine();
            }
        }
        
        int servicoIndex;

        System.out.println("\nServiços disponíveis:");
        limparTela();
        listarServicos();
        System.out.print("Selecione o serviço (número): ");
            
        servicoIndex = scanner.nextInt();
        scanner.nextLine();
                
        while (true) {
            if (servicoIndex >= 0 && servicoIndex < servicos.size()) {
                 break;
            } else {
                System.out.println("Serviço Invalido!Por favor, digite um número válido.");
                System.out.println("\nServiços disponíveis:");
                listarServicos();
                System.out.print("Selecione o serviço (número): ");
                servicoIndex = scanner.nextInt();
                scanner.nextLine();
            }
        }

        Pet pet = pets.get(petIndex);
        Servico servico = servicos.get(servicoIndex);
        servico.setPet(pet);
        pet.getTutor().addServico(servico);

        System.out.print("Informe a data para agendar: ");
        servico.setData(scanner.nextLine());

        System.out.println("Serviço agendado com sucesso!");
    }

    public static void mensagemInicial(){
            System.out.println("\n=== Veterinária Debug Pet ===");
            System.out.println("1 - Cadastrar Tutor");
            System.out.println("2 - Cadastrar Pet");
            System.out.println("3 - Cadastrar Serviço");
            System.out.println("4 - Listar Tutores");
            System.out.println("5 - Listar Pets");
            System.out.println("6 - Listar Serviços");
            System.out.println("7 - Agendar Serviço");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
    }

      public static void limparTela() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
        
        System.out.println("\033\143");

  }
}