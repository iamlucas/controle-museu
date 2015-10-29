package entity;

public class VisitanteEntity {
    private long id;
    public String cpf; // boolean
    public String nacionalidade; // boolean
    public int idade;
    public String sexo; // boolean
    public String grauInstrucao; // string
    public String meioTransporte; // string
    
    public VisitanteEntity(){
        super();
//        nacionalidade = null; // false
//        idade = 0;
//        sexo = null; // false
//        grauInstrucao = null;
//        meioTransporte = null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getGrauInstrucao() {
        return grauInstrucao;
    }

    public void setGrauInstrucao(String grauInstrucao) {
        this.grauInstrucao = grauInstrucao;
    }

    public String getMeioTransporte() {
        return meioTransporte;
    }

    public void setMeioTransporte(String meioTransporte) {
        this.meioTransporte = meioTransporte;
    }

   
    
    

}
