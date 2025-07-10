import java.util.ArrayList;
import java.util.Scanner;

class Produto {
    private int id;
    private String nome;
    private int quantidade;
    private double preco;

    public Produto(int id, String nome, int quantidade, double preco) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getTotal() {
        return quantidade * preco;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Nome: " + nome +
                " | Qtd: " + quantidade +
                " | Preço: R$" + preco +
                " | Total: R$" + getTotal();
    }
}

class PDV {
    static ArrayList<Produto> carrinho = new ArrayList<>();
    static int contadorId = 1;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n=== PDV - Caixa do Mercado ===");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Atualizar produto");
            System.out.println("4. Remover produto");
            System.out.println("5. Mostrar total da compra");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> adicionarProduto();
                case 2 -> listarProdutos();
                case 3 -> atualizarProduto();
                case 4 -> removerProduto();
                case 5 -> mostrarTotal();
                case 0 -> System.out.println("Encerrando PDV...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    static void adicionarProduto() {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Quantidade: ");
        int qtd = scanner.nextInt();
        System.out.print("Preço unitário: ");
        double preco = scanner.nextDouble();

        Produto produto = new Produto(contadorId++, nome, qtd, preco);
        carrinho.add(produto);
        System.out.println("✅ Produto adicionado!");
    }

    static void listarProdutos() {
        if (carrinho.isEmpty()) {
            System.out.println("Carrinho vazio.");
            return;
        }
        System.out.println("\n--- Produtos no carrinho ---");
        for (Produto p : carrinho) {
            System.out.println(p);
        }
    }

    static void atualizarProduto() {
        System.out.print("ID do produto a atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Produto produto = encontrarPorId(id);
        if (produto == null) {
            System.out.println("❌ Produto não encontrado.");
            return;
        }

        System.out.print("Novo nome (atual: " + produto.getNome() + "): ");
        produto.setNome(scanner.nextLine());

        System.out.print("Nova quantidade (atual: " + produto.getQuantidade() + "): ");
        produto.setQuantidade(scanner.nextInt());

        System.out.print("Novo preço (atual: R$" + produto.getPreco() + "): ");
        produto.setPreco(scanner.nextDouble());

        System.out.println("✅ Produto atualizado!");
    }

    static void removerProduto() {
        System.out.print("ID do produto a remover: ");
        int id = scanner.nextInt();

        Produto produto = encontrarPorId(id);
        if (produto != null) {
            carrinho.remove(produto);
            System.out.println("🗑️ Produto removido!");
        } else {
            System.out.println("❌ Produto não encontrado.");
        }
    }

    static void mostrarTotal() {
        double total = 0;
        for (Produto p : carrinho) {
            total += p.getTotal();
        }
        System.out.printf("🧾 Total da compra: R$ %.2f\n", total);
    }

    static Produto encontrarPorId(int id) {
        for (Produto p : carrinho) {
            if (p.getId() == id) return p;
        }
        return null;
    }
}
