package calc;

import java.awt.EventQueue;


import javax.swing.JFrame;

import javax.swing.JScrollPane;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;


import java.awt.Color;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Stack;
import javax.swing.Action;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sun.security.rsa.RSAPrivateCrtKeyImpl;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.DropMode;


public class VentanaDB{

	private JFrame frmVentanaDB;
	
	private JTable table;
	
	
	
	private final Action action_3 = new SwingAction_3();
			
		
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDB window = new VentanaDB();
					window.frmVentanaDB.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaDB() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frmVentanaDB = new JFrame();
		frmVentanaDB.setTitle("Base de datos de ip's");
		frmVentanaDB.setBounds(100, 100, 484, 418);
		frmVentanaDB.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVentanaDB.getContentPane().setLayout(new BoxLayout(frmVentanaDB.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		frmVentanaDB.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 446, 283);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"IP", "M\u00E1scara", "Clase", "Publica o privada", "APIPA", "Difusion", "Reservada", "ip red", "ip gateway", "ip broascast", "Hosts"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(81);
		table.getColumnModel().getColumn(0).setMinWidth(81);
		table.getColumnModel().getColumn(1).setPreferredWidth(81);
		table.getColumnModel().getColumn(1).setMinWidth(81);
		table.getColumnModel().getColumn(2).setPreferredWidth(81);
		table.getColumnModel().getColumn(2).setMinWidth(81);
		table.getColumnModel().getColumn(3).setPreferredWidth(81);
		table.getColumnModel().getColumn(3).setMinWidth(81);
		table.getColumnModel().getColumn(4).setPreferredWidth(81);
		table.getColumnModel().getColumn(4).setMinWidth(81);
		table.getColumnModel().getColumn(5).setPreferredWidth(81);
		table.getColumnModel().getColumn(5).setMinWidth(81);
		table.getColumnModel().getColumn(6).setPreferredWidth(81);
		table.getColumnModel().getColumn(6).setMinWidth(81);
		scrollPane.setViewportView(table);
		
		JLabel Titulo = new JLabel("IP's calculadas");
		Titulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		Titulo.setBounds(163, 11, 135, 14);
		panel.add(Titulo);
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.setAction(action_3);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(163, 330, 135, 41);
		panel.add(btnNewButton);
		
		
		}
		

	
		
		public void mostrar(Connection conn, JTable table) {
			
			DefaultTableModel model;
			String [] nColumnas = {"IP", "M\u00E1scara", "Clase", "Publica o privada", "APIPA", "Difusion", "Reservada", "ip red", "ip gateway", "ip broascast", "Hosts"};
			model = new DefaultTableModel(null, nColumnas);
			
			String sentencia = "SELECT * FROM ips";
			String [] filas = new String[11];
			Statement st = null;
			ResultSet rs = null;
			
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sentencia);
				while(rs.next()) {
					for (int i = 0; i < 11; i++) {
						filas[i] = rs.getString(i+1);
					}
					model.addRow(filas);
				}
				table.setModel(model);
			} catch (Exception e) {
				System.out.println("No se pudo mostrar los datos");
			}
			
			
			
	}
	
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Actualizar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			final String url = "jdbc:postgresql://localhost:5432/Calculadora IP";
    	    final String user = "postgres";
    	    final String password = "17camarones";
    	    
    	    Connection conn = null;
    	    
    	    try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	JOptionPane.showMessageDialog(null, "La conexión con la DB fue exitosa");
    	    
			mostrar(conn, table);
		}
	}
	}
	



