import java.math.BigDecimal;
import java.math.RoundingMode;

public class Arredondar {
    private double valor;

    public Arredondar(double valor) {    
        this.valor = valor;    
    }

    public double getValor() {
        return valor;
    }    

    public double arrendondar(int casasDecimais){ 
        // Regra de arredondamento: Banker's rounding ou ABNT-NBR 5891:1977
        
        BigDecimal valorArredondado = BigDecimal.valueOf(valor).setScale(casasDecimais,RoundingMode.HALF_EVEN);     

        return valorArredondado.doubleValue();
    }
}
