package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.Departamento;
import net.miginfocom.swing.MigLayout;

public class VentanaMostrarDepartamentos extends JFrame {

	private JPanel contentPane;
	private JTable tablaListado;
	private JButton btnCerrar;
	private Controlador controlador;

	/**
	 * Create the frame.
	 */
	public VentanaMostrarDepartamentos() {
		setBounds(100, 100, 666, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[][grow][]"));
		
		JLabel lblTitulo = new JLabel("Listado de Departamentos:");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblTitulo, "cell 0 0 2 1");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 1 2 1,grow");
		
		tablaListado = new JTable();
		tablaListado.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cod Departamento", "Codigo Centro", "Tipo Dir", "Presupuesto", "Nombre"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Integer.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablaListado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setViewportView(tablaListado);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
			}
		});
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(btnCerrar, "cell 0 2 2 1,alignx center,aligny center");
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public void setListaDepartamentos(ArrayList<Departamento> lista) {
		
		DefaultTableModel modelo = (DefaultTableModel) tablaListado.getModel();
		modelo.setRowCount(0);
		for (Departamento departamento : lista) {
			Object fila [] = {departamento.getCodDepartamento(), departamento.getCodCentro(), departamento.getTipoDir(),
					departamento.getPresupuesto(), departamento.getNombre()};
			modelo.addRow(fila);
		}
		
		
	}
	
	

}
