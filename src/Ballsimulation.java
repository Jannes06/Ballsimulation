import GLOOP.*;
public class Ballsimulation{
    private GLKamera kamera;
    GLLicht licht;
    GLHimmel himmel;
    GLBoden boden;
    private GLTastatur tastatur;

    private Gravitationsball gBall;
    private Ball ball;
    private Hindernis[] hindernis;

    public Ballsimulation(){
        kamera = new GLSchwenkkamera(800,500);
        kamera.setzePosition(0,500,2000);
        licht  = new GLLicht();       
        boden  = new GLBoden("src/Boden.jpg");
        himmel = new GLHimmel("src/Himmel.jpg");
        tastatur = new GLTastatur();

        hindernis = new Hindernis[2];
        hindernis[0] = new Hindernis(1000,200,0, 50,400,1300);
        hindernis[1] = new Hindernis(-1000,200,0, 50,400,1300);

        gBall = new Gravitationsball(0,200,100,20);
        gBall.werfen(new GLVektor(1,0,0));
        ball = new Ball (0,200,0, 20);
        ball.werfen(new GLVektor(2,0,0));

        fuehreAus();
    }

    public void fuehreAus(){
        while (!tastatur.esc()){
            gBall.bewegeDich();
            ball.bewegeDich();
            for (int j=0; j<2; j++) {
                ball.bearbeiteHindernis(hindernis[j]);
                gBall.bearbeiteHindernis(hindernis[j]);
            }
            Sys.warte();
        }
        Sys.beenden();
    }
    
}
