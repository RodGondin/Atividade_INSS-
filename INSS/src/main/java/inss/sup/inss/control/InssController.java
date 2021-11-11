package inss.sup.insssup.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import inss.sup.insssup.DTO.inssDTO;

@RestController
public class inssController {

    // Calculando o desconto inss
    public float DescontoINSS(float Total) {
        float INSS = 0.0;

        if (Total < 429.00) {
            INSS = Total * (0.0765);
        } else if (Total >= 429.00 && Total < 540.00) {
            INSS = Total * (0.0865);
        } else if (Total >= 540.00 && Total < 715.00) {
            INSS = Total * (0.0900);
        } else if (Total >= 715.00 && Total < 1430.00) {
            INSS = Total * (0.1100);
        } else if (Total >= 1430.00) {
            INSS = 157.00;
        }
        return INSS;
    }



    // Calculando o desconto irrf

    public float DescontoIRRF(float Total, float INSS) {

        float IRRF = 0.0;
        float TotalINSS = Total - INSS;

        if (TotalINSS < 1058.00) {
            IRRF = TotalINSS * (0.000);
        } else if (TotalINSS >= 1058.00 && Total < 2115.00) {
            IRRF = TotalINSS * (0.15);
        } else if (TotalINSS >= 2115.00) {
            IRRF = TotalINSS * (0.275);
        }
        return IRRF;
    }

    // Calculando o Salario Liquido

    public float SalarioLiquido(float Total, float INSS, float IRRF) {

        float Liquido = Total - INSS - IRRF;

        return Liquido;
    }

    @GetMapping("/{Total}")
    public inssDTO getDados(@PathVariable(name = "Total") float Total) {

        float INSS = DescontoINSS(Total);
        float IRRF = DescontoIRRF(Total, INSS);
        float Liquido = SalarioLiquido(Total, INSS, IRRF);

        return inssDTO.example(Total, INSS, IRRF, Liquido);
    }
}
