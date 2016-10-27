/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.EventoDAO;
import entidade.Evento;
import entidade.Setor;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Leal
 */
@Named(value = "eventoManagedBean")
@SessionScoped
public class EventoManagedBean implements Serializable {

    private ArrayList<Evento> eventos;
    private Evento evento;
    private EventoDAO eventoDAO;

    /**
     * @return the eventos
     */
    public EventoManagedBean() {
        evento = new Evento();
    }

    public ArrayList<Evento> getEventos() {

        eventos = new ArrayList<>();

        Evento ev = new Evento();

        ev.setId_evento(0);
        ev.setNome_evento("Metallica");
        ev.setCaminhoImagem("img/01.jpg");
        ev.setCaminhoImagemBack("img/01_back.jpg");
        ev.setDescricao("Metallica é uma banda norte-americana de heavy metal originaria de Los Angeles, mas com base em San Francisco. Os seus lançamentos incluem tempos rápidos, instrumentais, e musicalidade agressiva, a qual os colocou no lugar de uma das bandas fundadoras do Big Four of Thrash, conjuntamente com Slayer, Megadeth e Anthrax. O Metallica foi formado em 1981, após James Hetfield responder a um anúncio que Lars Ulrich colocou no jornal local. A sua formação atual apresenta os fundadores Ulrich (bateria) e Hetfield (vocal e guitarra base), o guitarrista Kirk Hammett (que se juntou à banda em 1983), e o baixista Robert Trujillo (membro desde 2003). Antes de chegarem à sua formação atual, a banda teve outros integrantes, sendo eles: Dave Mustaine (guitarra), Ron McGovney, Cliff Burton e Jason Newsted (baixo).");

        Setor set = new Setor("Pista", 150.00, 5000);
        ev.addSetores(set);
        Setor set1 = new Setor("Cadeira Inferior", 200.00, 5000);
        ev.addSetores(set1);
        Setor set2 = new Setor("Cadeira Superior", 100.00, 5000);
        ev.addSetores(set2);

        eventos.add(ev);

        Evento ev2 = new Evento();

        ev2.setId_evento(2);
        ev2.setNome_evento("CPM 22");
        ev2.setCaminhoImagem("img/02.png");
        ev2.setCaminhoImagemBack("img/02_back.jpg");
        ev2.setDescricao("CPM 22 é uma banda brasileira de hardcore melódico formada em 1995 na cidade de Barueri, São Paulo. Os membros, Badauí (vocal), Japinha (bateria), Luciano (guitarra), Fernando (baixo) e Phil (guitarra) já abriram shows de bandas internacionais como Lagwagon, No Fun at All, Down by Law e System of a Down (Rock in Rio 6, onde comemoravam 20 anos da banda). Foi uma das poucas bandas brasileiras de hardcore a ganhar um disco de ouro e fazer sucesso no mainstream, e com isso, abriu as portas para uma nova geração de bandas brasileiras de rock. Em 2008 ganharam um Grammy Latino de melhor álbum de rock brasileiro.");

        Setor set4 = new Setor("Pista Premium", 300.00, 5000);
        ev2.addSetores(set4);
        Setor set5 = new Setor("Pista", 120.00, 5000);
        ev2.addSetores(set5);
        Setor set6 = new Setor("Cadeira", 200.00, 5000);
        ev2.addSetores(set6);

        eventos.add(ev2);

        Evento ev3 = new Evento();

        ev3.setId_evento(3);
        ev3.setNome_evento("Natiruts");
        ev3.setCaminhoImagem("img/03.png");
        ev3.setCaminhoImagemBack("img/03_back.jpg");
        ev3.setDescricao("Natiruts é uma banda brasileira de reggae pop formada em Brasília em 1996. Chamada inicialmente Nativus, a banda de reggae foi rebatizada de Natiruts devido a um grupo catarinense de música regional, Os Nativos, que entrou com um processo. A banda brasíliense defende o reggae de raiz mas incorporou ao som uma grande influência brasileira. Quando ainda chamava-se Nativus, o grupo vendeu 40 mil discos independentes com o sucesso \"Presente de um beija-flor\", até ser contratada pela EMI. A nova edição do disco, Nativus, vendeu 450 mil cópias. O segundo disco, Povo Brasileiro, foi produzido por Liminha e, como o reggae de Bob Marley, tem músicas com mensagens de alto teor político, como \"Proteja-se e lute\" e \"Povo brasileiro\".");

        Setor set7 = new Setor("Pista", 220.00, 5000);
        ev3.addSetores(set7);
        Setor set8 = new Setor("Cadeira", 180.00, 5000);
        ev3.addSetores(set8);

        eventos.add(ev3);

        Evento ev4 = new Evento();

        ev4.setId_evento(4);
        ev4.setNome_evento("NovoNome4");
        ev4.setCaminhoImagem("img/03.png");
        ev4.setCaminhoImagemBack("img/03_back.jpg");
        ev4.setDescricao("descricao_4");

        Setor set9 = new Setor("Cadeira", 180.00, 5000);
        ev4.addSetores(set9);

        eventos.add(ev4);

        return eventos;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    /**
     * @param eventos the eventos to set
     */
    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    public int getTamanhoArray() {
        return eventos.size();
    }

    public String cadastrar() {
        eventoDAO.addEvento(evento);
        return "menu";
    }

}
