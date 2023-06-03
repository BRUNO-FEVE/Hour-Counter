package pages;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import components.PageModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopwatchPage extends PageModel {

    private JLabel labelCronometro;
    private JLabel labelDescricao;
    private JTextField textFieldDescricao;
    private JButton buttonStart;
    private JButton buttonStop;
    private JButton buttonEnviar;
    private Timer timer;
    private long startTime;

    public StopwatchPage(String superTitle, Container caixa) {
        super(superTitle, caixa);

        super.caixa.setLayout(new BorderLayout());

        EmptyBorder margin = new EmptyBorder(30, 0, 0, 0);

        labelCronometro = new JLabel("00:00:00");
        labelCronometro.setFont(new Font("Arial", Font.BOLD, 45));
        labelCronometro.setBorder(margin);

        labelDescricao = new JLabel("Descrição:");
        textFieldDescricao = new JTextField(14);
        buttonStart = new JButton("Start");
        buttonStop = new JButton("Stop");
        buttonEnviar = new JButton("Enviar");

        JPanel cronometroPanel = new JPanel();
        cronometroPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        cronometroPanel.add(labelCronometro);

        JPanel botoesPanel = new JPanel();
        botoesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 10));
        botoesPanel.add(buttonStart);
        botoesPanel.add(buttonStop);

        JPanel descricaoPanel = new JPanel();
        descricaoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        descricaoPanel.add(labelDescricao);
        descricaoPanel.add(textFieldDescricao);

        JPanel enviarPanel = new JPanel();
        enviarPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        enviarPanel.add(buttonEnviar);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(4, 1));
        contentPanel.add(cronometroPanel);
        contentPanel.add(botoesPanel);
        contentPanel.add(descricaoPanel);
        contentPanel.add(enviarPanel);

        super.caixa.add(contentPanel, BorderLayout.CENTER);

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startCronometro();
            }
        });

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopCronometro();
            }
        });

        buttonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviar();
            }
        });
    }

    private void startCronometro() {
        startTime = System.currentTimeMillis();
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long elapsedTime = System.currentTimeMillis() - startTime;
                int hours = (int) (elapsedTime / 3600000);
                int minutes = (int) ((elapsedTime / 60000) % 60);
                int seconds = (int) ((elapsedTime / 1000) % 60);
                labelCronometro.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
            }
        });
        timer.start();
    }

    private void stopCronometro() {
        if (timer != null) {
            timer.stop();
            timer = null;
        }
    }

    private void enviar() {
        stopCronometro();
        labelCronometro.setText("00:00:00");
        textFieldDescricao.setText("");
    }

}