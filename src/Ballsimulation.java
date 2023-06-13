import GLOOP.*;
public class Ballsimulation{
    private GLKamera kamera;
    GLLicht licht;
    GLHimmel himmel;
    GLBoden boden;
    private GLTastatur tastatur;

    private Gravitationsball gBall;
    private Ball ball;
    private Discoball dBall;

    private RandomBall rBall;
    private Hindernis[] hindernis;


    public Ballsimulation(){
        kamera = new GLSchwenkkamera(800,500);
        kamera.setzePosition(0,500,2000);
        licht  = new GLLicht();       
        boden  = new GLBoden("src/Boden.jpg");
        himmel = new GLHimmel("src/Himmel.jpg");
        tastatur = new GLTastatur();

        hindernis = new Hindernis[2];
        hindernis[0] = new Hindernis(1000,400,0, 50,800,1300);
        hindernis[1] = new Hindernis(-1000,400,0, 50,800,1300);

        gBall = new Gravitationsball(0,200,100,20);
        gBall.werfen(new GLVektor(3,0,0));

        ball = new Ball (0,200,0, 20);
        ball.werfen(new GLVektor(3,0,0));

        dBall = new Discoball(0,100,-100,30);
        dBall.werfen(new GLVektor(3,0,0));

        rBall = new RandomBall(0,100,0,30);
        rBall.werfen(new GLVektor(3,0,0));
        fuehreAus();
    }

    public void fuehreAus(){
        while (!tastatur.esc()){
            gBall.bewegeDich();
            ball.bewegeDich();
            dBall.bewegeDich();
            rBall.bewegeDich();
            for (int j=0; j<2; j++) {
                ball.bearbeiteHindernis(hindernis[j]);
                gBall.bearbeiteHindernis(hindernis[j]);
                dBall.bearbeiteHindernis(hindernis[j]);
                rBall.bearbeiteHindernis(hindernis[j]);
            }
            Sys.warte();
        }
        Sys.beenden();
    }
    
}
