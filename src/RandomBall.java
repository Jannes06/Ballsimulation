import GLOOP.*;
public class RandomBall extends Ball{


    public RandomBall (double pX, double pY , double pZ, double pRadius) {
        super(pX, pY, pZ, pRadius);

    }
        @Override
        public void bewegeDich() {
            kugel.verschiebe(bewegung);
            random();

    }
      public void random(){

        kugel.skaliere(( Math.random()*2)-1 , (Math.random()*2)-1 , (Math.random()*2)-1);

      }
}
