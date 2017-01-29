package software.ifto.frequencia.model;

import com.google.gson.Gson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import software.ifto.frequencia.model.Evento;
import software.ifto.frequencia.model.Parte;
import software.ifto.frequencia.model.Processo;

/**
 * Created by Marques de Souza on 12/12/2016.
 */

public class WebService {
    public List<Processo> processos;
    public WebService(){
        Processo processo=new Processo();
        processo.setNumeroProcesso(203);
        processo.setComarca("paraiso");
        processo.setJuiz("Jose Marcos");
        processo.setTipoProcesso("Indenizacao");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String dateInString="7-Jun-2013";
        Date date=new Date();
        try{
            date=formatter.parse(dateInString);
                    }catch (ParseException e){
            e.printStackTrace();
        }
        processo.setData(date);
        List<Parte> partes=new ArrayList<Parte>();
        Parte parte1= new Parte();
        Parte parte2= new Parte();
        Parte parte3= new Parte();
        parte1.setDocumento("000.000.000-00");
        parte1.setNome("fulano");
        parte1.setTipoDocumento("cpf");
        parte1.setTipo("reu");

        parte1.setDocumento("000.000.000-00");
        parte1.setNome("fulano1");
        parte1.setTipoDocumento("cpf");
        parte1.setTipo("reu");

        parte1.setDocumento("000.000.000-00");
        parte1.setNome("fulano2");
        parte1.setTipoDocumento("cpf");
        parte1.setTipo("reu");
        partes.add(parte1);
        partes.add(parte2);
        partes.add(parte3);
        processo.setPartes(partes);
        Evento evento1 = new Evento();
        Evento evento2 = new Evento();
        Evento evento3 = new Evento();
        evento1.setAssunto("descricao");
        evento1.setConteudo("blabla");
        evento1.setData(date);
        evento1.setDescricao("etc etc etc etc");
        evento2.setAssunto("descricao");
        evento2.setConteudo("blabla");
        evento2.setData(date);
        evento2.setDescricao("etc etc etc etc");
        evento3.setAssunto("descricao");
        evento3.setConteudo("blabla");
        evento3.setData(date);
        evento3.setDescricao("etc etc etc etc");
        List<Evento>eventos=new ArrayList<Evento>();
        eventos.add(evento1);
        eventos.add(evento2);
        eventos.add(evento3);
        processos.add(processo);

    }
    public boolean verificarUsuario(String usuario,String senha){
        return true;
    }

    public List<Processo> ConsultaCPF(String cpf){
        List<Parte> partesTemp = new ArrayList<Parte>();
        List<Processo> processosResult = new ArrayList<Processo>();
        for (Processo processo:processos){
            partesTemp= processo.getPartes();
            for(Parte parte: partesTemp){
                if((cpf.equals(parte.getDocumento()))&&("cpf".equals(parte.getTipoDocumento()))){
                    processosResult.add(processo);
                    break;
                }
            }
        }
        return processosResult;
    }
    public Processo retornaProcesso(Integer numeroProcesso){
        Processo processoRetorno=new Processo();
        for (Processo processo:processos){
            if(numeroProcesso==processo.getNumeroProcesso()){
                processoRetorno = processo;
                break;
            }
        }
        return processoRetorno;
    }
    public String retornaProcessoJson(Integer numeroProcesso){
        String processoRetorno=null;
        Gson gson= new Gson();
        for (Processo processo:processos){
            if(numeroProcesso==processo.getNumeroProcesso()){
                processoRetorno = gson.toJson(processo);
                break;
            }
        }// addcionar como e um numero de processo ,longtext descricao
        return processoRetorno;
    }
    public Processo retornoProcessoObj(String json){
        Gson gson= new Gson();
        Processo processo=gson.fromJson(json,Processo.class);
        return processo;
    }

}
