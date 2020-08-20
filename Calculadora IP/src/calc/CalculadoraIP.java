package calc;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.apple.dnssd.TXTRecord;

import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CalculadoraIP {

	private JFrame frmCalculadoraIp;
	private JTextField textOct1;
	private JTextField textOct2;
	private JTextField textOct3;
	private JTextField textOct4;
	private JTextField textMask;
	private JLabel lblNewLabel_3;
	private JTextField textClase;
	private final Action action = new SwingAction();
	private JTextField textPoP;
	private JTextField textAPIPA;
	private JTextField textDifusión;
	private JTextField textReservada;
	private JTextField textIpRed;
	private JTextField textIpGateway;
	private JTextField textIpBroadcast;
	private JTextField textHosts;
	
	//Octetos de la IP y mascara
	int o1,o2,o3,o4, mask;
	private final Action action_1 = new SwingAction_1();
	
	//ArrayList para guardar las ip
	static ArrayList<Ip> listaIP = new ArrayList<Ip>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraIP window = new CalculadoraIP();
					window.frmCalculadoraIp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculadoraIP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculadoraIp = new JFrame();
		frmCalculadoraIp.setTitle("Calculadora IP");
		frmCalculadoraIp.setBounds(100, 100, 688, 431);
		frmCalculadoraIp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculadoraIp.getContentPane().setLayout(null);
		
		textOct1 = new JTextField();
		textOct1.setBounds(102, 36, 86, 20);
		frmCalculadoraIp.getContentPane().add(textOct1);
		textOct1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ingresar su direcci\u00F3n IP aqu\u00ED:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 642, 14);
		frmCalculadoraIp.getContentPane().add(lblNewLabel);
		
		textOct2 = new JTextField();
		textOct2.setColumns(10);
		textOct2.setBounds(198, 36, 86, 20);
		frmCalculadoraIp.getContentPane().add(textOct2);
		
		textOct3 = new JTextField();
		textOct3.setColumns(10);
		textOct3.setBounds(294, 36, 86, 20);
		frmCalculadoraIp.getContentPane().add(textOct3);
		
		textOct4 = new JTextField();
		textOct4.setColumns(10);
		textOct4.setBounds(390, 36, 86, 20);
		frmCalculadoraIp.getContentPane().add(textOct4);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E1scara:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(486, 39, 62, 14);
		frmCalculadoraIp.getContentPane().add(lblNewLabel_1);
		
		textMask = new JTextField();
		textMask.setColumns(10);
		textMask.setBounds(556, 36, 86, 20);
		frmCalculadoraIp.getContentPane().add(textMask);
		
		JLabel lblNewLabel_2 = new JLabel(".");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(187, 38, 11, 14);
		frmCalculadoraIp.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel(".");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(284, 39, 11, 14);
		frmCalculadoraIp.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel(".");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_2.setBounds(380, 39, 11, 14);
		frmCalculadoraIp.getContentPane().add(lblNewLabel_2_2);
		
		lblNewLabel_3 = new JLabel("Clase:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(126, 99, 62, 14);
		frmCalculadoraIp.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("P\u00FAblica o Privada:");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(75, 124, 113, 14);
		frmCalculadoraIp.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Protocolo APIPA:");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_2.setBounds(43, 149, 145, 14);
		frmCalculadoraIp.getContentPane().add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Difusi\u00F3n:");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1_1.setBounds(75, 174, 113, 14);
		frmCalculadoraIp.getContentPane().add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Reservada:");
		lblNewLabel_3_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1_1_1.setBounds(75, 199, 113, 14);
		frmCalculadoraIp.getContentPane().add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Direcci\u00F3n de Red:");
		lblNewLabel_3_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1_1_1_1.setBounds(75, 224, 113, 14);
		frmCalculadoraIp.getContentPane().add(lblNewLabel_3_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1_1 = new JLabel("Direcci\u00F3n de Gateway:");
		lblNewLabel_3_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1_1_1_1_1.setBounds(43, 249, 145, 14);
		frmCalculadoraIp.getContentPane().add(lblNewLabel_3_1_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1_1_1 = new JLabel("Direcci\u00F3n de Broadcast:");
		lblNewLabel_3_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1_1_1_1_1_1.setBounds(23, 274, 165, 14);
		frmCalculadoraIp.getContentPane().add(lblNewLabel_3_1_1_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1_1_1_1 = new JLabel("Rango de host's:");
		lblNewLabel_3_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1_1_1_1_1_1_1.setBounds(23, 299, 165, 14);
		frmCalculadoraIp.getContentPane().add(lblNewLabel_3_1_1_1_1_1_1_1);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.setAction(action);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(275, 330, 116, 52);
		frmCalculadoraIp.getContentPane().add(btnNewButton);
		
		textClase = new JTextField();
		textClase.setHorizontalAlignment(SwingConstants.CENTER);
		textClase.setEditable(false);
		textClase.setBounds(198, 98, 44, 20);
		frmCalculadoraIp.getContentPane().add(textClase);
		textClase.setColumns(10);
		
		textPoP = new JTextField();
		textPoP.setHorizontalAlignment(SwingConstants.CENTER);
		textPoP.setEditable(false);
		textPoP.setColumns(10);
		textPoP.setBounds(198, 123, 116, 20);
		frmCalculadoraIp.getContentPane().add(textPoP);
		
		textAPIPA = new JTextField();
		textAPIPA.setHorizontalAlignment(SwingConstants.CENTER);
		textAPIPA.setEditable(false);
		textAPIPA.setColumns(10);
		textAPIPA.setBounds(198, 148, 116, 20);
		frmCalculadoraIp.getContentPane().add(textAPIPA);
		
		textDifusión = new JTextField();
		textDifusión.setHorizontalAlignment(SwingConstants.CENTER);
		textDifusión.setEditable(false);
		textDifusión.setColumns(10);
		textDifusión.setBounds(198, 173, 116, 20);
		frmCalculadoraIp.getContentPane().add(textDifusión);
		
		textReservada = new JTextField();
		textReservada.setHorizontalAlignment(SwingConstants.CENTER);
		textReservada.setEditable(false);
		textReservada.setColumns(10);
		textReservada.setBounds(198, 198, 116, 20);
		frmCalculadoraIp.getContentPane().add(textReservada);
		
		textIpRed = new JTextField();
		textIpRed.setHorizontalAlignment(SwingConstants.CENTER);
		textIpRed.setEditable(false);
		textIpRed.setColumns(10);
		textIpRed.setBounds(198, 223, 116, 20);
		frmCalculadoraIp.getContentPane().add(textIpRed);
		
		textIpGateway = new JTextField();
		textIpGateway.setHorizontalAlignment(SwingConstants.CENTER);
		textIpGateway.setEditable(false);
		textIpGateway.setColumns(10);
		textIpGateway.setBounds(198, 248, 116, 20);
		frmCalculadoraIp.getContentPane().add(textIpGateway);
		
		textIpBroadcast = new JTextField();
		textIpBroadcast.setHorizontalAlignment(SwingConstants.CENTER);
		textIpBroadcast.setEditable(false);
		textIpBroadcast.setColumns(10);
		textIpBroadcast.setBounds(198, 273, 116, 20);
		frmCalculadoraIp.getContentPane().add(textIpBroadcast);
		
		textHosts = new JTextField();
		textHosts.setHorizontalAlignment(SwingConstants.CENTER);
		textHosts.setEditable(false);
		textHosts.setColumns(10);
		textHosts.setBounds(198, 298, 278, 20);
		frmCalculadoraIp.getContentPane().add(textHosts);
		
		JButton btnNewButton_1_1 = new JButton("Ver DB");
		btnNewButton_1_1.setAction(action_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1_1.setBounds(553, 347, 89, 23);
		frmCalculadoraIp.getContentPane().add(btnNewButton_1_1);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Calcular");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			String ip, clase, pop, apipa, difusion, reservada, ipred, ipgw, ipbroad, hosts;
			int nh;
			
			//Se obtienen los octetos de la ip
			o4 = Integer.parseInt(textOct4.getText());
			o3 = Integer.parseInt(textOct3.getText());
			o2 = Integer.parseInt(textOct2.getText());
			o1 = Integer.parseInt(textOct1.getText());
			
			//Se obtiene la máscara
			mask = Integer.parseInt(textMask.getText());
			
			//Se verifica que la ip y la mascara esten dentro del rango
			if(o1 > 255 || o2 > 255 || o3 > 255 || o4 > 255 || mask > 32) {
				JOptionPane.showMessageDialog(null, "IP inválida o máscara inválida");
				textOct1.setText("");
				textOct2.setText("");
				textOct3.setText("");
				textOct4.setText("");
				textMask.setText("");
			}else { 
				
				//Se calcula
				
				
				//Clase y saber si es publica o privada, tambien difusion (D)
				if(0 <= o1 && o1 <= 126) {
					textClase.setText("A");
					if(o1 == 10) {
						textPoP.setText("Privada");
					}else {
						textPoP.setText("Pública");
					}
				}else if(128 <= o1 && o1 <= 191){
					textClase.setText("B");
					if(o1 == 172 && (16 <= o2 && o2 <= 31)) {
						textPoP.setText("Privada");
					}else {
						textPoP.setText("Pública");
					}
				}else if(192 <= o1 && o1 <= 223){
					textClase.setText("C");
					if(o1 == 192 && 168 == o2) {
						textPoP.setText("Privada");
					}else {
						textPoP.setText("Pública");
					}
				}else if(224 <= o1 && o1 <= 239){
					textClase.setText("D");
					textDifusión.setText("Multicast");
					textPoP.setText("-");
				}else if(240 <= o1 && o1 <= 255) {
					textClase.setText("E");
					textReservada.setText("Uso experimental");
					textPoP.setText("-");
				}else {
					textClase.setText("-");
					textPoP.setText("-");
				}
				
				
				//Difusión (A, B y C)
				if(0 <= o1 && o1 <= 223) {
					textDifusión.setText("Unicast");
				}
				
				
				//Reservadas
				if(o1 == 0 &&  o2 ==0 && o3 == 0 && o4 == 0) {
					textReservada.setText("Sí. Identificación local");
				}else if(o1 == 127) {
					textReservada.setText("Sí. Loopback");
				}else {
					textReservada.setText("No");
				}
	
				
				//APIPA
				if(o1 == 169 && o2 == 254) {
					textAPIPA.setText("Sí");
				}else{
					textAPIPA.setText("No");
				}
			
				
				//Dieccion de red
				//pasamos a binario  los octetos d la ip
				String bin1 = Integer.toBinaryString(o1);
			    String bin2 = Integer.toBinaryString(o2);
			    String bin3 = Integer.toBinaryString(o3);
			    String bin4 = Integer.toBinaryString(o4);
			    
			    
			    //Se completan con 0
			   while(bin1.length() < 8) {
			    	bin1 = "0" + bin1;
			    }
			   while(bin2.length() < 8) {
			    	bin2 = "0" + bin2;
			   }
			   while(bin3.length() < 8) {
			    	bin3 = "0" + bin3;
			   }
			   while(bin4.length() < 8) {
			    	bin4 = "0" + bin4;
			   }
			   
			   //Máscara
			   int bitsred, bitshosts;
			   bitshosts = 32 - mask;
			   bitsred = mask;
			   
			   int om1=0, om2=0, om3=0, om4=0;
			   
			   //octetos que sus bits son iguales
			   if (mask <= 8) {
				    om2 = 0;
				    om3 = 0;
				    om4 = 0;
			   }else if(8 < mask && mask <= 16) {
				   om1 = 255;
				   om3 = 0;
				   om4 = 0;
			   }else if(16 < mask && mask <= 24) {
				   om1 = 255;
				   om2 = 255;
				   om4 = 0;
			   }else {
				   om1 = 255;
				   om2 = 255;
				   om3 = 255;
			   }
			   
			   //paamos a binario
			   String mbin1 = Integer.toBinaryString(om1);
			   String mbin2 = Integer.toBinaryString(om2);
			   String mbin3 = Integer.toBinaryString(om3);
			   String mbin4 = Integer.toBinaryString(om4);
			    
			    
			    //Se completan con 0
			   while(mbin1.length() < 8) {
			    	mbin1 = "0" + mbin1;
			    }
			   while(mbin2.length() < 8) {
			    	mbin2 = "0" + mbin2;
			   }
			   while(mbin3.length() < 8) {
			    	mbin3 = "0" + mbin3;
			   }
			   while(mbin4.length() < 8) {
			    	mbin4 ="0" + mbin4;
			   }
			   
			   //El octeto que falta de la mascara
			   if (mask <= 8) {
				    bitshosts = bitshosts-24;
				    bitsred = 8-bitshosts;
				    
				    if (bitsred != 0) {
				    	om1 = 1;
				    	mbin1 = Integer.toBinaryString(om1);
					    
					    while(mbin1.length() != bitsred) {
					    	mbin1 = mbin1 + "1";
					    }
				    }
				    
				    //se completa
				    while(mbin1.length() < 8) {
				    	mbin1 = mbin1 + "0";
				    }
				    
				  //octeto en decimal
				    if(bitsred==1) {om1=128;} else if(bitsred==2){om1=192;} else if(bitsred==3){om1=224;} else if(bitsred==4){om1=240;}
				    else if(bitsred==5){om1=248;} else if(bitsred==6){om1=252;} else if(bitsred==7){om1=254;} else if(bitsred==8){om1=255;}
				    
			   }else if(8 < mask && mask <= 16) {
				   bitshosts = bitshosts-16;
				   bitsred = 8-bitshosts;
				   
				   if (bitsred != 0) {
				    	om2 = 1;
				    	mbin2 = Integer.toBinaryString(om2);
					    
					    while(mbin2.length() != bitsred) {
					    	mbin2 = mbin2 + "1";
					    }
				    }
				    
				 //se completa
				    while(mbin2.length() < 8) {
				    	mbin2 = mbin2 + "0";
				    }
				    
				  //octeto en decimmal
				    if(bitsred==1) {om2=128;} else if(bitsred==2){om2=192;} else if(bitsred==3){om2=224;} else if(bitsred==4){om2=240;}
				    else if(bitsred==5){om2=248;} else if(bitsred==6){om2=252;} else if(bitsred==7){om2=254;} else if(bitsred==8){om2=255;}
				    
			   }else if(16 < mask && mask <= 24) {
				   bitshosts = bitshosts-8;
				   bitsred = 8-bitshosts;
				   
				   if (bitsred != 0) {
				    	om3= 1;
				    	mbin3 = Integer.toBinaryString(om3);
				    	
					    while(mbin3.length() != bitsred) {
					    	mbin3 = mbin3 + "1";
					    }
				    }
				    
				 //se completa
				    while(mbin3.length() < 8) {
				    	mbin3 = mbin3 + "0";
				    }
				    
				  //octeto en decimal
				    if(bitsred==1) {om3=128;} else if(bitsred==2){om3=192;} else if(bitsred==3){om3=224;} else if(bitsred==4){om3=240;}
				    else if(bitsred==5){om3=248;} else if(bitsred==6){om3=252;} else if(bitsred==7){om3=254;} else if(bitsred==8){om3=255;}
				    
			   }else {
				   bitsred = 8-bitshosts;
				   
				   if (bitsred != 0) {
				    	om4= 1;
				    	mbin4 = Integer.toBinaryString(om4);
				    	
					    while(mbin4.length() != bitsred) {
					    	mbin4 = mbin4 + "1";
					    }
				    }
				    
				 //se completa
				    while(mbin4.length() < 8) {
				    	mbin4 = mbin4 + "0";
				    }
				    
				  //octeto en decimal
				    if(bitsred==1) {om4=128;} else if(bitsred==2){om4=192;} else if(bitsred==3){om4=224;} else if(bitsred==4){om4=240;}
				    else if(bitsred==5){om4=248;} else if(bitsred==6){om4=252;} else if(bitsred==7){om4=254;} else if(bitsred==8){om4=255;}
			   }
			   
			 /*  System.out.println("\n\nmask: "+om1+"."+om2+"."+om3+"."+om4);
			   System.out.println("mask: "+mbin1+"."+mbin2+"."+mbin3+"."+mbin4); */
			   
			   int binoct1 = Integer.parseInt(bin1, 2);
		       int binoct2 = Integer.parseInt(bin2, 2);
		       int binoct3 = Integer.parseInt(bin3, 2);
		       int binoct4 = Integer.parseInt(bin4, 2);
			   int mbinoct1 = Integer.parseInt(mbin1, 2);
		       int mbinoct2 = Integer.parseInt(mbin2, 2);
		       int mbinoct3 = Integer.parseInt(mbin3, 2);
		       int mbinoct4 = Integer.parseInt(mbin4, 2);
			   
			   int x = binoct1 & mbinoct1;
			   int y = binoct2 & mbinoct2;
			   int z = binoct3 & mbinoct3;
			   int w = binoct4 & mbinoct4;
	    		
			   String ir1 = Integer.toString(x, 10);
			   String ir2 = Integer.toString(y, 10);
			   String ir3 = Integer.toString(z, 10);
			   String ir4 = Integer.toString(w, 10);
			 
			   textIpRed.setText(ir1+"."+ir2+"."+ir3+"."+ir4);
			   
			   //Diereccion de gateway
			   int igw4 = Integer.parseInt(ir4)+1;
			   textIpGateway.setText(ir1+"."+ir2+"."+ir3+"."+igw4);
			   
			   //Direccion de broadcast
	    	   //Calculamos la wildcard
	    	   int wo1 = 255 - om1;
	    	   int wo2 = 255 - om2;
	    	   int wo3 = 255 - om3;
	    	   int wo4 = 255 - om4;
 
	    	   String x1 = Integer.toBinaryString(wo1);
	    	   String x2 = Integer.toBinaryString(wo2);
	    	   String x3 = Integer.toBinaryString(wo3);
	    	   String x4 = Integer.toBinaryString(wo4);
	    	    
	    	   //se completa
		       while(x1.length() < 8) {
		        	x1 = "0" + x1;
		       }
		       while(x2.length() < 8) {
		        	x2 = "0" + x2;
		       }
		       while(x3.length() < 8) {
		        	x3 = "0" + x3;
		       }
		       while(x4.length() < 8) {
		        	x4 = "0" + x4;
		       }
	    		
	    	   int x5 = Integer.parseInt(x1, 2);
	    	   int x6 = Integer.parseInt(x2, 2);
	    	   int x7 = Integer.parseInt(x3, 2);
	    	   int x8 = Integer.parseInt(x4, 2);
	    	    
	    	   int rb1 = binoct1 | x5;
	    	   int rb2 = binoct2 | x6;
	    	   int rb3 = binoct3 | x7;
	    	   int rb4 = binoct4 | x8;
	    	    
	    	   String ib1 = Integer.toString(rb1, 10);
	    	   String ib2 = Integer.toString(rb2, 10);
	    	   String ib3 = Integer.toString(rb3, 10);
	    	   String ib4 = Integer.toString(rb4, 10);
	    	    
	    	   textIpBroadcast.setText(ib1+"."+ib2+"."+ib3+"."+ib4);
	    	   
	    	   if(o1 == Integer.parseInt(ib1) && o2 == Integer.parseInt(ib2) && o3 == Integer.parseInt(ib3) && o4 == Integer.parseInt(ib4)) {
	    		   textDifusión.setText("Broadcast");
	    	   }
	    	  
			   //Rango de hosts
			   //N° de hosts
			   nh = (int) Math.pow(2, 32-mask) - 2;
			   int ih4 = Integer.parseInt(ib4)-1;
			   String ihmin,ihmax;
			   ihmin = textIpGateway.getText();
			   ihmax = ib1+"."+ib2+"."+ib3+"."+ih4;
			   
			   textHosts.setText(ihmin+" - "+ihmax+" ("+nh+" hosts)");
			   
			   //Agregar al arraylist y DB
			   ip = o1+"."+o2+"."+o3+"."+o4;
			   clase = textClase.getText();
			   pop = textPoP.getText();
			   apipa = textAPIPA.getText();
			   difusion = textDifusión.getText();
			   reservada = textReservada.getText();
			   ipred = textIpRed.getText();
			   ipgw = textIpGateway.getText();
			   ipbroad = textIpBroadcast.getText();
			   hosts = textHosts.getText();
			   
			   Ip calc = new Ip(ip, clase, pop, apipa, difusion, reservada, ipred, ipgw, ipbroad, hosts, mask);
			   listaIP.add(calc);
			   
			   final String url = "jdbc:postgresql://localhost:5432/Calculadora IP";
	    	    final String user = "postgres";
	    	    final String password = "17camarones";
	    	    
	    	    Connection conn = null;
	    	    
	    	    try {
	    	    	conn = DriverManager.getConnection(url, user, password);
	    	    	JOptionPane.showMessageDialog(null, "La conexión con la DB fue exitosa, se procederá a agregar los datos de la ip a la DB");
	    	    	Statement st = conn.createStatement();
	    	    	st.executeUpdate("INSERT INTO ips(ip, mascara, clase, pop, apipa, difusion, reservada, ipred, ipgateway, ipbroadcast, hosts)VALUES"
	    	    			+ "('"+ip+"','"+mask+"','"+clase+"','"+pop+"','"+apipa+"','"+difusion+"',"
	    	    			+ "'"+reservada+"','"+ipred+"','"+ipgw+"','"+ipbroad+"','"+hosts+"')");
	    	    	JOptionPane.showMessageDialog(null, "Se agregaron los datos en la DB con éxito");
	    	    	conn.close();
	    	    }
	    	    catch(SQLException e1) {
	    	    	System.out.println(e1.getMessage());
	    	    	JOptionPane.showMessageDialog(null, "Error en la conexión");
	    	    	}
				
			}
		}
	}
	
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Ver DB");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			
    	    
			VentanaDB.main(null);
		}
	}
}
