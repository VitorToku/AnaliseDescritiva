import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Dado> populacao = new ArrayList<>();
        double[] dados = {9, 8, 6, 4, 2, 1};          
        
        inserirDados(populacao, dados);

        System.out.println(somaPopulacao(populacao));
        System.out.println(media(populacao));
        System.out.println(variancia(populacao));   
        System.out.println(desvioPadrao(populacao));      


    }

    private static boolean temFrequencia(List<Dado> populacao){
        boolean temFrequencia = false;
        for(Dado dado:populacao){
            if(dado.getFrequencia() != 0){
                temFrequencia = true;
            }
        }
        return temFrequencia;
    }
    private static double variancia(List<Dado> populacao){        
        double somaDoDesvio = 0;
        double variancia = 0;
        double media = media(populacao);      

        // caso seja um dado bruto, essa é a fórmula
        for(Dado dado:populacao){
            somaDoDesvio += Math.pow((dado.getValor() - media) , 2) ;
        }
        variancia = somaDoDesvio/populacao.size();       

        return arrendondar(variancia, 4);
    }
    private static double desvioPadrao(List<Dado> populacao){
        return arrendondar(Math.sqrt(variancia(populacao)), 4);
    }
    private static double media(List<Dado> populacao){
        double media = 0;
       
        media = somaPopulacao(populacao)/populacao.size();

        return media;
    }

    private static double somaPopulacao(List<Dado> populacao){
        double soma = 0;

        for(Dado dado: populacao){
            soma += dado.getValor();
        }

        return soma;
    }

    private static void inserirDados(List<Dado> populacao, double[] dados){
        for(double dado: dados){
            Dado novoDado = new Dado(dado);
            populacao.add(novoDado);
        }
    }

    private static double arrendondar(double numero, int casasDecimais){ 
        // Regra de arredondamento: Banker's rounding ou ABNT-NBR 5891:1977
        
        BigDecimal valorArredondado = BigDecimal.valueOf(numero).setScale(casasDecimais,RoundingMode.HALF_EVEN);     

        return valorArredondado.doubleValue();
    }


}
