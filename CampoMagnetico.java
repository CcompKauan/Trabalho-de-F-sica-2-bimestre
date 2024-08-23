
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CampoMagnetico extends JFrame {

    private JTextField campoRaio;
    private JLabel resultadoDentro, resultadoFora;

    public CampoMagnetico() {
        setTitle("Cálculo do Campo Magnético Induzido");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        
        JPanel painelRaio = new JPanel();
        painelRaio.add(new JLabel("Raio das placas (mm):"));
        campoRaio = new JTextField(10);
        painelRaio.add(campoRaio);
        add(painelRaio);

        
        JButton botaoDentro = new JButton("Calcular dentro das placas");
        botaoDentro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularDentro();
            }
        });
        add(botaoDentro);

        
        resultadoDentro = new JLabel("Resultado: ");
        add(resultadoDentro);

        
        JButton botaoFora = new JButton("Calcular fora das placas");
        botaoFora.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularFora();
            }
        });
        add(botaoFora);

        
        resultadoFora = new JLabel("Resultado: ");
        add(resultadoFora);
    }

    private void calcularDentro() {
        try {
            double raio = Double.parseDouble(campoRaio.getText()) / 1000.0; 
            double rDentro = 0.5 * raio; 
            resultadoDentro.setText(String.format("Distância dentro das placas: %.2f mm", rDentro * 1000));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um número válido para o raio.");
        }
    }

    private void calcularFora() {
        try {
            double raio = Double.parseDouble(campoRaio.getText()) / 1000.0; 
            double rFora = Math.pow(2, 1.0/3.0) * raio; 
            resultadoFora.setText(String.format("Distância fora das placas: %.2f mm", rFora * 1000));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um número válido para o raio.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CampoMagnetico().setVisible(true);
            }
        });
    }
}
class fisica {

}