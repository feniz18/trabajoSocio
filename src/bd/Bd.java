package bd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import bd.Conexion;
import java.sql.*;
public class Bd extends JFrame {

	private JPanel contentPane;
	private JTextField nombres;
	private JTextField apellidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bd frame = new Bd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Bd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nombres = new JTextField();
		nombres.setBounds(149, 50, 248, 26);
		contentPane.add(nombres);
		nombres.setColumns(10);
		
		apellidos = new JTextField();
		apellidos.setColumns(10);
		apellidos.setBounds(149, 100, 248, 26);
		contentPane.add(apellidos);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(38, 56, 46, 14);
		contentPane.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(38, 106, 46, 14);
		contentPane.add(lblApellidos);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conexion miConexion = new Conexion();
				
				Statement miEstado = miConexion.irConexion();
				
				
				try {
					
					String sql = "INSERT INTO USUARIO"
					miEstado.executeUpdate(sql);
					
					while(miResultado.next()) 
					{
						System.out.println(miResultado.getInt("id") + " " + miResultado.getString("nombres") + " " + miResultado.getString("apellidos") );
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnGuardar.setBounds(83, 164, 263, 47);
		contentPane.add(btnGuardar);
	}
}
