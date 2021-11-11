package inss.sup.insssup.DTO;

public class inssDTO {

    private float Total;
    private float Liquido;
    private float INSS;
    private float IRRF;

    public float getTotal() {
        return this.Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }

    public float getLiquido() {
        return this.Liquido;
    }

    public void setLiquido(float Liquido) {
        this.Liquido = Liquido;
    }

    public float getINSS() {
        return this.INSS;
    }

    public void setINSS(float INSS) {
        this.INSS = INSS;
    }

    public float getIRRF() {
        return this.IRRF;
    }

    public void setIRRF(float IRRF) {
        this.IRRF = IRRF;
    }

    public inssDTO() {
    }

    public inssDTO(float Total, float INSS, float IRRF, float Liquido) {
        this.Total = Total;
        this.INSS = INSS;
        this.IRRF = IRRF;
        this.Liquido = Liquido;
    }

    public static inssDTO example(float Total, float INSS, float IRRF, float Liquido) {
        inssDTO example = new inssDTO(Total, INSS, IRRF, Liquido);

        return example;
    }
}
