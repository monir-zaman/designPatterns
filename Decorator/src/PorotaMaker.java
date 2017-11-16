import java.math.BigDecimal;


 abstract class Porota {   
    protected String description = "Porota";  
   
    public String getDescription(){
        return description;
    }
   
    public abstract BigDecimal price();
}


 class VajaPorota extends Porota {
   
    public VajaPorota(String desc){
       description = desc;
    }
   
    @Override
    public BigDecimal price() {
        return new BigDecimal("10.0");
    }
   
}

 abstract class PorotaDecorator extends Porota {  
   
    @Override
    public abstract BigDecimal price();
   
}

 class VajiDecorator extends PorotaDecorator{
    Porota currentPorota;
   
    public VajiDecorator(Porota sw){
        currentPorota = sw;
    }
   
    @Override
    public String getDescription(){
        return currentPorota.getDescription() + ",with dal-vaji";
    }
    @Override
    public BigDecimal price() {
        return currentPorota.price().add(new BigDecimal("10.0"));
    }
   
}

public class PorotaMaker {
   
    public static void main(String args[]){
       
        Porota myPorota = new VajaPorota("Vaja Porota");
        System.out.printf("Price of %s is %.2f taka %n", myPorota.getDescription(), 
                                                     myPorota.price());
       
        //adding extra cheese using Decorator Pattter
        myPorota = new VajiDecorator(myPorota);
        System.out.printf("Price of %s is %.2f taka %n", myPorota.getDescription(), 
                                                     myPorota.price());
    }
}
