package Dao;

import android.content.ClipData;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import model.ItemConsulta;

/**
 * Created by UltronI7 on 06/12/2016.
 */

public class ItemConsultaDAO implements GenericDao<ItemConsulta> {
    private DB jdb;
    private Jongo jongo;
    private MongoCollection collection;


    public ItemConsultaDAO(){

        jdb = new MongoClient().getDB("vetline");
        jongo = new Jongo(jdb);
        collection = jongo.getCollection("item_consulta");
    }
    @Override
    public boolean inserir(ItemConsulta itemConsulta) {

        try{
            collection.insert(itemConsulta);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean atualizar(ItemConsulta old, ItemConsulta novo) {
        return false;
    }

    @Override
    public boolean excluir(ItemConsulta itemConsulta) {
        return false;
    }

    @Override
    public ItemConsulta buscar(ItemConsulta itemConsulta) {
        return null;
    }

    public ArrayList<ItemConsulta> buscar(String login){
        try{
            MongoCursor<ItemConsulta> cursor = collection.find("animal.dono: #",login).as(ItemConsulta.class);

            ArrayList<ItemConsulta> itens = new ArrayList<>();

            for(ItemConsulta it:cursor){
                itens.add(it);
            }
            return itens;
        }catch (Exception e){
            return null;
        }
    }
    public ArrayList<ItemConsulta> buscar(String login, boolean realizada){
        try{
            MongoCursor<model.ItemConsulta> cursor = collection.find("animal.dono: #, consulta.realizada: #",login,realizada).as(model.ItemConsulta.class);

            ArrayList<model.ItemConsulta> itens = new ArrayList<>();

            for(model.ItemConsulta it:cursor){
                itens.add(it);
            }
            return itens;
        }catch (Exception e){
            return null;
        }
    }
}
