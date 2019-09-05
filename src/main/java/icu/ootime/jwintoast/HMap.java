package icu.ootime.jwintoast;

import icu.ootime.jwintoast.javacpp.HString;
import icu.ootime.jwintoast.javacpp.HStringMap;

import java.util.*;
import java.util.function.BiConsumer;

final public class HMap implements Map<String,String> {
    private HStringMap hStringMap;

    private HMap(HStringMap hStringMap){
        if(hStringMap.isNull()){
            throw new NullPointerException(HStringMap.class.getName().concat(" is Not Found"));
        }
        this.hStringMap=hStringMap;
    }
    public HMap(){
        this(new HStringMap());
    }

    @Override
    public synchronized int size() {
        return (int)this.hStringMap.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return this.hStringMap.isEmpty();
    }

    @Override
    public synchronized boolean containsKey(Object key) {
        HString hstrkey = new HString((String) key);
        HStringMap.Iterator iterator=this.hStringMap.find(hstrkey);
        return iterator.equals(this.hStringMap.end())?false:true;
    }

    @Override
    public boolean containsValue(Object value) {
        // TODO
        return false;
    }

    @Override
    public synchronized String get(Object key) {
        HString hstrkey = new HString((String) key);
        HStringMap.Iterator iterator=this.hStringMap.find(hstrkey);

        if(iterator.equals(this.hStringMap.end())){
            return null;
        }
        HString val_hstr =iterator.second();
        return val_hstr.c_str().getString();
    }

    @Override
    public synchronized String put(String key, String value) {
        HString hstrkey = new HString(key);
        HString hstrval = new HString(value);
        this.hStringMap.put(hstrkey,hstrval);
        return hstrkey.c_str().getString();
    }

    @Override
    public  synchronized String remove(Object key) {
        HString hstrkey = new HString((String) key);
        return this.hStringMap.erase(hstrkey)>0?hstrkey.toString():"";
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> m) {
        // TODO
    }

    @Override
    public void clear()  {
        this.clear();
    }

    @Override
    public Set<String> keySet() {
        Set<String> hashset=new HashSet<>();
        getKeyValue((key,value)->{
            hashset.add(key);
        });
        return hashset;
    }

    @Override
    public Collection<String> values() {
        List<String> vals=new ArrayList(this.size());
        getKeyValue((key,value)->{
            vals.add(value);
        });
        return vals;
    }

    @Override
    public Set<Entry<String, String>> entrySet() {
        Set<Entry<String, String>> hashSet = new HashSet<>();
        getKeyValue((key,value)->{
            hashSet.add(new HashMap.SimpleEntry<String,String>(key,value));
        });
        return hashSet;
    }

    private synchronized void getKeyValue(BiConsumer<String,String> consumer){
        String [] vals=new String[this.size()];
        String [] keys=new String[this.size()];
        int i=0;
        for(HStringMap.Iterator begin=this.hStringMap.begin();!begin.equals(this.hStringMap.end());begin.increment(),i++){
            String val=begin.second().toString();
            String key=begin.first().toString();
            consumer.accept(key,val);
        }
    }
}
