package projeto;

public class Conta {
    private int id;
    private String nome;
    private String email;
    private String cpf;
    private String banco;
    private String saldo;

    
    // CONSTRUTOR COM ID
    public Conta(int id, String nome,String email,String cpf, String banco, String saldo ) {
       this.id= id;
       this.nome = nome;
       this.email = email;
       this.cpf = cpf;
       this.banco = banco;
       this.saldo = saldo;
    }
    
    // CONSTRUTOR SEM ID
    public Conta(String nome, String email, String cpf, String banco, String saldo) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.banco = banco;
        this.saldo = saldo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    
    
    
    
    
    
    
    
    
}
