import GLOOP.*;
public class Discoball extends Ball {
    public Discoball (double pX, double pY , double pZ, double pRadius){





        super(pX,pY,pZ,pRadius);
    }

    @Override
    public void bewegeDich() {
        kugel.verschiebe(bewegung);
        discoEffekt();
    }

      public void discoEffekt(){
        kugel.setzeFarbe(Math.random(),Math.random(),Math.random());

      }


}
