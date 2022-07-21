import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Font;

public class StickerGen {
    public void criar () throws Exception {
        // leitura da imagem
        BufferedImage ImgOriginal = ImageIO.read(new File("entrada/filme.jpg"));

        // criar uma nova imagem com transparência e com tamanho novo
        int largura = ImgOriginal.getWidth();
        int altura = ImgOriginal.getHeight();
        int NovaAltura = altura + 200;
        BufferedImage NovaImagem = new BufferedImage(largura, NovaAltura, BufferedImage.TRANSLUCENT);

            // configurar a fonte
            var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 32);
            graphics.setFont(fonte);
            
        //copiar a imagem original para nova imagem com memória
        Graphics2D graphics = (Graphics2D) NovaImagem.getGraphics();
        graphics.drawImage(ImgOriginal, 0, 0, null);

        // escrever uma frase na imagem nova
        graphics.drawString("Debeste", 0, NovaAltura - 100);

        // escrever a nova imagem em um arquivo
        ImageIO.write(NovaImagem, "png", new File("saida/figurinha.png"));
    }

    public static void main(String[] args) throws Exception {
        var geradora = new StickerGen();
        geradora.criar();
    }
}
