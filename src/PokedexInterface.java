import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author didilero
 * 
 */
public class PokedexInterface extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Pokemon> listePokemon;
	private JPanel monPanel, panelAj;
	private JOptionPane jop;
	private JLabel txtTitre, txtNorm, txtNorm2, image;
	private JTextField jtf1, jtf2;
	private JMenuBar menuBarre;
	private JMenu menuConsultation, menuAccueil, menuRecherche, menuQuitter;
	private JButton btnOk, btnRetour;
	private int statutOk;
	private JTable tableau;
	private JScrollPane scrollPane;
	private Object[][] data = new Object[12][2];
	private String[] title = { "Nom", "Type" };

	public PokedexInterface() {
		this.listePokemon = new ArrayList<Pokemon>();
		this.setTitle("Pokedex");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 500);

		this.monPanel = new JPanel();
		this.txtTitre = new JLabel("Bienvenue dans votre POKEDEX !");
		this.image = new JLabel(new ImageIcon("C:/Users/avary.TERTIAIRE/Downloads/title3.png"));
		this.monPanel.add(this.image);
		this.monPanel.setLayout(new GridLayout(4, 1, 2, 5));

		this.tableau = new JTable(data, title);
		this.txtNorm = new JLabel("Vous possédez :" + this.listePokemon.size()
				+ " Pokemons !");
		this.monPanel.add(txtTitre);
		this.monPanel.setOpaque(false);
		this.monPanel.add(this.txtNorm);
		this.setContentPane(new AfficheImage("C:/Users/avary.TERTIAIRE/Downloads/pikachu-raichu.jpg"));
		this.setJMenuBar(barreDeMenu());
		this.getContentPane().add(monPanel);
		this.setVisible(true);
	}

	public JMenuBar barreDeMenu() { // Sert a creer la barre de menu et permet
									// simplement l'appel de cette fonction pour
									// la charger
		this.menuBarre = new JMenuBar();
		this.menuAccueil = new JMenu("Accueil");
		this.menuBarre.add(this.menuAccueil);
		menuAccueil.add(
				new JMenuItem("Retourner à l'accueil", new ImageIcon("C:/Users/avary.TERTIAIRE/Downloads/poke.png"))).addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						retour();
					}
				});
		this.menuConsultation = new JMenu("Consultation");
		this.menuBarre.add(this.menuConsultation);
		menuConsultation.add(
				new JMenuItem("Voir Pokedex", new ImageIcon("C:/Users/avary.TERTIAIRE/Downloads/poke.png"))).addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						consultation();
					}
				});
		menuConsultation.add(
				new JMenuItem("Ajouter Pokemon", new ImageIcon("C:/Users/avary.TERTIAIRE/Downloads/poke.png"))).addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						menuAjouter();
					}
				});
		menuConsultation.add(
				new JMenuItem("Supprimer Pokemon", new ImageIcon("C:/Users/avary.TERTIAIRE/Downloads/poke.png"))).addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						menuSupprimer();
					}
				});

		this.menuRecherche = new JMenu("Recherche");
		this.menuBarre.add(this.menuRecherche);
		menuRecherche.add(
				new JMenuItem("Rechercher un pokemon", new ImageIcon("C:/Users/avary.TERTIAIRE/Downloads/poke.png"))).addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						menuRecherche();
					}
				});
		this.menuQuitter = new JMenu("Quitter");
		this.menuBarre.add(this.menuQuitter);
		menuQuitter.add(
				new JMenuItem("Retourner à l'aventure", new ImageIcon("C:/Users/avary.TERTIAIRE/Downloads/psy.png"))).addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
		return this.menuBarre;
	}

	public void menuAjouter() { // Affiche la saisie du texte ainsi que les
								// bouton pour choisir le type du pokemon
		this.getContentPane().removeAll();
		this.panelAj = new JPanel();
		this.panelAj.setLayout(new GridLayout(6, 1));
		this.txtNorm = new JLabel("Quel nom : ");
		this.jtf1 = new JTextField();
		this.txtNorm2 = new JLabel("Quel type : ");
		this.jtf2 = new JTextField();
		this.btnOk = new JButton("OK");
		this.statutOk = 1;
		this.btnOk.addActionListener(this);
		this.btnRetour = new JButton("Retour");
		this.btnRetour.addActionListener(this);

		this.panelAj.add(txtNorm);
		this.panelAj.add(jtf1);
		this.panelAj.add(txtNorm2);
		this.panelAj.add(jtf2);
		this.panelAj.add(btnOk);
		this.panelAj.add(btnRetour);
		this.setContentPane(new AfficheImage("C:/Users/avary.TERTIAIRE/Downloads/fond.jpg"));
		this.setJMenuBar(barreDeMenu());
		this.getContentPane().add(panelAj);
		this.revalidate();
	}

	public void menuSupprimer() {
		this.getContentPane().removeAll();
		this.monPanel = new JPanel();
		this.monPanel.setLayout(new GridLayout(6, 1));
		this.txtNorm = new JLabel("Quel Pokemon souhaitez vous supprimer ? : ");
		this.jtf1 = new JTextField();
		this.btnOk = new JButton("OK");
		this.statutOk = 2;
		this.btnOk.addActionListener(this);
		this.btnRetour = new JButton("Retour");
		this.btnRetour.addActionListener(this);

		this.monPanel.add(txtNorm);
		this.monPanel.add(jtf1);
		this.monPanel.add(btnOk);
		this.monPanel.add(btnRetour);
		this.setContentPane(new AfficheImage("C:/Users/avary.TERTIAIRE/Downloads/bg.png"));
		this.setJMenuBar(barreDeMenu());
		this.getContentPane().add(monPanel);
		this.revalidate();
	}

	public void menuRecherche() {
		this.getContentPane().removeAll();
		this.monPanel = new JPanel();
		this.monPanel.setLayout(new GridLayout(6, 1));
		this.txtNorm = new JLabel("Quel Pokemon cherchez vous ? : ");
		this.jtf1 = new JTextField();
		this.btnOk = new JButton("OK");
		this.statutOk = 3;
		this.btnOk.addActionListener(this);
		this.btnRetour = new JButton("Retour");
		this.btnRetour.addActionListener(this);

		this.monPanel.add(txtNorm);
		this.monPanel.add(jtf1);
		this.monPanel.add(btnOk);
		this.monPanel.add(btnRetour);
		this.setContentPane(new AfficheImage("C:/Users/avary.TERTIAIRE/Downloads/gm.png"));
		this.setJMenuBar(barreDeMenu());
		this.getContentPane().add(monPanel);
		this.revalidate();
	}

	@SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent evenement) {
		if (evenement.getSource() == this.btnRetour) {
			retour();
		}
		if (evenement.getSource() == this.btnOk) {
			this.jop = new JOptionPane();
			if (this.statutOk == 1) {
				int option = jop.showConfirmDialog(null,
						"Voulez vous confirmer c est information ?",
						"Confirmation saise", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (option == JOptionPane.OK_OPTION) {
					String repNom = this.jtf1.getText();
					String repType = this.jtf2.getText();
					ajouter(repNom, repType);
				} else {
					retour();
				}
			} else {
				if (this.statutOk == 2) {
					int option = jop.showConfirmDialog(null,
							"Voulez vous confirmer cette suppression ? ",
							"Confirmation saise", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					if (option == JOptionPane.OK_OPTION) {
						String repNom = this.jtf1.getText();
						System.out.println("ok jusque la");
						supprimer(repNom);
					} else {
						retour();
					}
				} else {
					if (this.statutOk == 3) {
						String repNom = this.jtf1.getText();
						if (this.listePokemon.contains(recherche(repNom))) {
							this.jop.showMessageDialog(null, "Le Pokemon : "
									+ repNom + " est bien dans le pokedex !",
									"Information sur la recherche",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							this.jop.showMessageDialog(null,
									"Le Pokemon n'est pas dans le pokedex",
									"Information sur la recherche",
									JOptionPane.WARNING_MESSAGE);
						}
					}
				}
			}

		}
	}

	public void retour() {
		this.getContentPane().removeAll();
		this.monPanel = new JPanel();
		this.monPanel.setLayout(new GridLayout(4, 1, 2, 5));
		this.image = new JLabel(new ImageIcon("C:/Users/avary.TERTIAIRE/Downloads/title3.png"));
		this.monPanel.add(this.image);
		this.txtTitre = new JLabel("Bienvenue dans votre POKEDEX !");
		this.monPanel.add(txtTitre);
		this.monPanel.setOpaque(false);
		this.txtNorm = new JLabel("Vous possédez actuellement :"
				+ this.listePokemon.size() + " Pokemons !");
		this.monPanel.add(this.txtNorm);
		this.setContentPane(new AfficheImage("C:/Users/avary.TERTIAIRE/Downloads/pikachu-raichu.jpg"));
		this.setJMenuBar(barreDeMenu());
		this.getContentPane().add(monPanel);
		this.revalidate();
	}

	public void consultation() {
		this.getContentPane().removeAll();
		this.monPanel = new JPanel();
		this.tableau = new JTable(this.data, this.title);
		this.tableau.setRowHeight(30); // espacement des cellules
		this.tableau
				.setPreferredScrollableViewportSize(new Dimension(300, 300));
		this.scrollPane = new JScrollPane(this.tableau);
		this.monPanel.add(this.scrollPane);

		this.setJMenuBar(barreDeMenu());
		this.getContentPane().add(monPanel);
		this.monPanel.setOpaque(false);
		this.revalidate();
	}

	public int getNombrePokemon() {
		return this.listePokemon.size();
	}

	public void ajouter(String rep1, String rep2) {
		Pokemon unPokemon = new Pokemon(rep1, rep2);
		this.listePokemon.add(unPokemon);
		int i = 0, max = this.data.length;
		while (i < max && this.tableau.getValueAt(i, 0) != null) {
			i = i + 1;

		}
		if (i < max) {
			this.data[i][0] = rep1;
			this.data[i][1] = rep2;
			this.tableau.setValueAt(data[i][0], i, 0);
			this.tableau.setValueAt(data[i][1], i, 1);
			consultation();
		} else {
			this.txtNorm = new JLabel(
					"Il n'y a plus de place dans votre Pokedex !");
		}

	}

	public Pokemon recherche(String unPokemon) {
		int i = 0;
		Pokemon rep = null;
		while (i < listePokemon.size()
				&& !unPokemon.equals(this.listePokemon.get(i).getNom())
				&& this.tableau.getValueAt(i, 0) != null) {
			i++;
		}
		if (i < listePokemon.size()) {
			rep = this.listePokemon.get(i);
		}
		return rep;
	}

	public void supprimer(String nomPokemon) {
		Pokemon rep = recherche(nomPokemon);
		if (this.listePokemon.contains(rep)) {
			this.listePokemon.remove(rep);
			int i = 0;
			while (i < this.data.length
					&& !this.tableau.getValueAt(i, 0).equals(nomPokemon)) {
				i = i + 1;
			}
			if (i < this.data.length) {
				this.tableau.setValueAt(null, i, 0);
				this.tableau.setValueAt(null, i, 1);
				consultation();
			} else {
				System.out.println("nn");
				this.txtNorm = new JLabel(
						"Votre pokemon n'existe pas dans votre pokedex !");
				this.monPanel.add(this.txtNorm);
				this.getContentPane().add(this.monPanel);
				this.revalidate();
			}
		}

	}

	@SuppressWarnings("serial")
	class AfficheImage extends JPanel {
		// Déclaration de la propriété fond de type Image
		private Image fond;

		// Création du constructeur de la classe
		AfficheImage(String s) {
			// Permet de charger une image
			fond = getToolkit().getImage(s);
		}

		/*
		 * Cette méthode est appelée automatiquement lors du chargement ou du
		 * redimensionnement de la fenêtre
		 */
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(fond, 0, 0, getWidth(), getHeight(), this);
		}
	}
}