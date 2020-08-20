package calc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.math.BigInteger;
import java.util.Arrays;

import javax.swing.Action;
import java.awt.Font;

public class Calc2 {

	private JFrame frmCalculadoraIpV;
	private JTextField textIpv6;
	private JTextField textNewip;
	private final Action action = new SwingAction();
	private JTextField textHosts;
	private JTextField textMask;
	private JTextField textIPred;
	private final Action action_1 = new SwingAction_1();
	private JTextField textTipoo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc2 window = new Calc2();
					window.frmCalculadoraIpV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calc2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculadoraIpV = new JFrame();
		frmCalculadoraIpV.setTitle("Calculadora IP v2");
		frmCalculadoraIpV.setBounds(100, 100, 657, 353);
		frmCalculadoraIpV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculadoraIpV.getContentPane().setLayout(null);
		
		textIpv6 = new JTextField();
		textIpv6.setBounds(206, 34, 316, 20);
		frmCalculadoraIpV.getContentPane().add(textIpv6);
		textIpv6.setColumns(10);
		
		JLabel lblNewLabel = new JLabel(" IPv6: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 37, 186, 14);
		frmCalculadoraIpV.getContentPane().add(lblNewLabel);
		
		textNewip = new JTextField();
		textNewip.setEditable(false);
		textNewip.setColumns(10);
		textNewip.setBounds(206, 65, 316, 20);
		frmCalculadoraIpV.getContentPane().add(textNewip);
		
		JLabel lblNewIp = new JLabel("Ipv6 completa: ");
		lblNewIp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewIp.setBounds(53, 68, 143, 14);
		frmCalculadoraIpV.getContentPane().add(lblNewIp);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.setAction(action);
		btnNewButton.setBounds(532, 30, 89, 23);
		frmCalculadoraIpV.getContentPane().add(btnNewButton);
		
		JLabel lblTipoDeIpv_1 = new JLabel("Tipo de IPv6: ");
		lblTipoDeIpv_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoDeIpv_1.setBounds(113, 99, 83, 14);
		frmCalculadoraIpV.getContentPane().add(lblTipoDeIpv_1);
		
		JLabel lblCalcularIpSegn = new JLabel(" Calcular IP seg\u00FAn hots (IPv4)");
		lblCalcularIpSegn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCalcularIpSegn.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalcularIpSegn.setBounds(10, 139, 285, 20);
		frmCalculadoraIpV.getContentPane().add(lblCalcularIpSegn);
		
		textHosts = new JTextField();
		textHosts.setBounds(85, 182, 86, 20);
		frmCalculadoraIpV.getContentPane().add(textHosts);
		textHosts.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Hosts:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(29, 185, 46, 14);
		frmCalculadoraIpV.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mask:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(29, 216, 46, 14);
		frmCalculadoraIpV.getContentPane().add(lblNewLabel_1_1);
		
		textMask = new JTextField();
		textMask.setEditable(false);
		textMask.setColumns(10);
		textMask.setBounds(85, 213, 86, 20);
		frmCalculadoraIpV.getContentPane().add(textMask);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ip de red:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setBounds(10, 244, 65, 14);
		frmCalculadoraIpV.getContentPane().add(lblNewLabel_1_1_1);
		
		textIPred = new JTextField();
		textIPred.setEditable(false);
		textIPred.setColumns(10);
		textIPred.setBounds(85, 241, 86, 20);
		frmCalculadoraIpV.getContentPane().add(textIPred);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setAction(action_1);
		btnNewButton_1.setBounds(193, 181, 89, 23);
		frmCalculadoraIpV.getContentPane().add(btnNewButton_1);
		
		textTipoo = new JTextField();
		textTipoo.setEditable(false);
		textTipoo.setBounds(206, 96, 316, 20);
		frmCalculadoraIpV.getContentPane().add(textTipoo);
		textTipoo.setColumns(10);
	}
	
	public String toHex(String arg) {
	    return String.format("%040x", new BigInteger(1, arg.getBytes()));
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Ingresar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			String ipv6 = textIpv6.getText(); //la que agrega el usuario
			if(ipv6 == "::1") {
				textTipoo.setText("Loopback, unicast");
			}
			
				if(ipv6 == "fc00::") {
					textTipoo.setText("Direccion local unica");
				}
			
				if(ipv6 == "::ffff:0:0") {
					textTipoo.setText("Trancision de ipv4");
				}
			
				if(ipv6 == "::ffff:0:0:0") {
					textTipoo.setText("Trancision de ipv4");
				}
				
				if(ipv6 == "64:ff9b::") {
					textTipoo.setText("Trancision de ipv4");
				}
				
				if(ipv6 == "2002::") {
					textTipoo.setText("Trancision de ipv4");
				}
				
				if(ipv6 == "2001::") {
					textTipoo.setText("Usado por el protocolo de túneles Teredo");
				}
				
				if(ipv6 == "2001:2::") {
					textTipoo.setText("Asignado a Benchmarking Methodology Working Group ");
				}
				
				if(ipv6 == "2001:10::") {
					textTipoo.setText("ORCHID");
				}
				
				if(ipv6 == "2001:db8::") {
					textTipoo.setText("Documentacion");
				}
				
				if(ipv6 == "ff0X::1") {
					textTipoo.setText("Multicast");
				}
				
				if(ipv6 == "ff0X::2") {
					textTipoo.setText("Multicast");
				}
				
				if(ipv6 == "ff02::5") {
					textTipoo.setText("Multicast");
				}
				
				if(ipv6 == "ff02::6") {
					textTipoo.setText("Multicast");
				}
				
				if(ipv6 == "ff02::9") {
					textTipoo.setText("Multicast");
				}
				
				if(ipv6 == "ff02::a") {
					textTipoo.setText("Multicast");
				}
				
				if(ipv6 == "ff02::d") {
					textTipoo.setText("Multicast");
				}
				
				if(ipv6 == "ff0X::fb") {
					textTipoo.setText("Multicast");
				}
				
				if(ipv6 == "ff0X::101") {
					textTipoo.setText("Multicast");
				}
				
				if(ipv6 == "ff02::1:1") {
					textTipoo.setText("Multicast");
				}
				
				if(ipv6 == "ff02::1:2") {
					textTipoo.setText("Multicast");
				}
				
				if(ipv6 == "ff02::1:3") {
					textTipoo.setText("Multicast");
				}
				
				if(ipv6 == "ff05::1:3") {
					textTipoo.setText("Multicast");
				}
				
				if(ipv6 == "FF02::1:FF00:0000") {
					textTipoo.setText("Multicast");
				}
				
				if(ipv6 == "FF02:0:0:0:0:2:FF00::") {
					textTipoo.setText("Multicast");
				}
			
			String idf = "::";
			if (textIpv6.getText() == idf) {
				textTipoo.setText("Direccion indefinida");
				textNewip.setText("Direccion indefinida");
			}else {
			
				
				
			//Saber si hay algún "::" 
			int w=0; //no hay
			if (ipv6.contains(idf)) {
				w=1; // si hay
				System.out.println("\nSi hay un ::");
			}
			
			
			String[] s = ipv6.split(":");
			
			//Para contar cuantos ':' hay
			String b = ":";
			int i =0;
			while (ipv6.indexOf(b) > -1) {
			      ipv6 = ipv6.substring(ipv6.indexOf(b)+b.length(),ipv6.length());
			      i++; 
			}
			System.out.println("Hay "+i+" ':''");
		
			
			
			System.out.println(Arrays.asList(s));
		
			for (int j = 0; j < (i+1); j++) {
				System.out.println("s"+(j+1)+": "+s[j]);
			}
			
			
			//Para saber si algún segmento se pasa de 4
			int z = 0;
			for (int j = 0; j < (i+1); j++) {
				if (s[j].length() > 4) {
					z =1;
				}
			}
			
			 if((i > 7) || z == 1) {
				JOptionPane.showMessageDialog(null, "Error de sintaxis de ipv6");
				textIpv6.setText("");
			}else { //Se calcula
				
				System.out.println("\nSe calcula\n");
				
				
				int v = 0;
				for (int j = 0; j < (i+1); j++) {
					if (s[j] == null) {
						v = j+1;
					}
				}

				if(i == 7 && w ==1 ) {
					for (int j = 0; j < (i+1); j++) {
						if (s[j].length() != 4) {
							while (s[j].length() != 4) {
								s[j] = "0" +  s[j];
							}
						}
					}
					System.out.println("\n\nip: "+s[0]+":"+s[1]+":"+s[2]+":"+s[3]+":"+s[4]+":"+s[5]+":"+s[6]+":"+s[7]);
				}
				
				int sv = 0;
				if (w == 1 && i != 7) {
					
						System.out.println("Cantidad de ':' "+i+"\n");
						for (int j = 0; j < (i+1); j++) {
							System.out.println("\nSegmento "+(j+1)+": ");
							if (s[j].length() != 4) {
								System.out.println("Segmento "+(j+1)+" es de tamaño: "+s[j].length());
								int svc = 0;
								while (s[j].length() < 4) {
									s[j] = "0" +  s[j];
									System.out.println("Al Segmento "+(j+1)+" se le sumo un 0 ");
									svc++;
									System.out.println("Sgmento vacio contador: "+svc);
									if(svc == 4) {
										sv = j;
										System.out.println("Segmento vacio: "+sv);
									}
								}
							}
						}
						
						s[sv] = "";
						
						while( i != 7) {
							s[sv] = s[sv]+":";
							i++; 
						}
		
						System.out.println("\n"+Arrays.asList(s));
						
						String newip;
						String aux = "";
						String q = ""; 
						
						for(String str: s) {
					        aux=aux+q+str;
					        q = ":";
					        }
					    System.out.println(aux);
						newip = aux;
						
						//SE REPITE EL CODIGO ANTERIOR

						//Saber si hay algún "::" 
						int p=0; //no hay
						if (newip.contains("::")) {
							p=1; // si hay
							System.out.println("\nSi hay un ::");
						}
						
						
						String[] seg = newip.split(":");
						
						//Para contar cuantos ':' hay
						String m = ":";
						int n =0;
						while (newip.indexOf(m) > -1) {
						      newip = newip.substring(newip.indexOf(m)+m.length(),newip.length());
						      n++; 
						}
						System.out.println("Hay "+n+" ':''");
					
						
						
						System.out.println(Arrays.asList(seg));
					
						for (int j = 0; j < (n+1); j++) {
							System.out.println("seg"+(j+1)+": "+seg[j]);
						}
				
							
							System.out.println("\nSe calcula\n");
							
							
							int l = 0;
							for (int j = 0; j < (n+1); j++) {
								if (seg[j] == null) {
								l = j+1;
								}
							}

							if(n == 7 && p ==1 ) {
								for (int j = 0; j < (n+1); j++) {
									if (seg[j].length() != 4) {
										while (seg[j].length() != 4) {
											seg[j] = "0" +  seg[j];
										}
									}
								}
								System.out.println("\n\nip: "+seg[0]+":"+seg[1]+":"+seg[2]+":"+seg[3]+":"+seg[4]+":"+seg[5]+":"+seg[6]+":"+seg[7]);
								String newip2;
								String aux2 = "";
								String q2 = ""; 
								
								for(String str: seg) {
							        aux2=aux2+q2+str;
							        q2 = ":";
							        }
							    System.out.println(aux2);
								newip2 = aux2;
								textNewip.setText(newip2);
								
								if(ipv6 == "::1") {
									textTipoo.setText("Loopback, unicast");
								}
								
								if(newip2 == "0000:0000:0000:0000:0000:0000:0000:0001") {
									textTipoo.setText("Loopback, unicast");
								}
							}
					
				}
	
				}
		}
			
			if(ipv6 == "::1") {
				textTipoo.setText("Loopback, unicast");
			}
			
			if(textTipoo.getText() == "0000:0000:0000:0000:0000:0000:0000:0001") {
				textTipoo.setText("Loopback, unicast");
			}
		}
		
		}	
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Calcular");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			//para calcular basado en hosts
			int hosts = Integer.parseInt(textHosts.getText());
			int mask=0 ;
			int o1=0,o2=0,o3=0,o4=0; 
			
					
					int x = 0;
					int p;
					int i = 0;
					int aux;
					
					while (x == 0) {
						mask = 32 - i;
						p = (int) Math.pow(2, i);
						aux = p-2;
						if (aux >= hosts) {
							x=1;
						}else {
							i++;
						}
					}
					
					
				if(0 <= mask && mask <= 15) {
					o1 = 10;
					o2 = 0;
					o3 = 0;
					o4 = 0;
				}
				
				if(16 <= mask && mask <= 23) {
					o1 = 172;
					o2 = 16;
					o3 = 0;
					o4 = 0;
				}
				
				if(24 <= mask && mask <= 32) {
					o1 = 192;
					o2 = 168;
					o3 = 0;
					o4 = 0;
				}
				
				textMask.setText(""+mask);
				textIPred.setText(o1+"."+o2+"."+o3+"."+o4);
			
		}
	}
	}
