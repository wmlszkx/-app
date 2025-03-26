package com.example.lgin3;

public class SharedHelper{
        private Context mContext;
        public SharedHelper(){
        }
        public SharedHelper(Context mContext){
        this.mContext=mContext;
        }
        //定义一个保存数据的方法
        public void save(String username,String passwd){
        SharedPreferences sp=mContext.getSharedPreferences("mysp", Context.MODE_PRIVATE);
        SharedPreferences.Editoreditor=sp.edit();
        editor.putString("username",username);
        editor.putString("passwd",passwd);
        editor.commit();
        Toast.makeText(mContext,"信息已写入SharedPreference中",
        Toast.LENGTH_SHORT).show();
        }
        //定义一个读取SP文件的方法
        public Map<String,String>read(){
        Map<String,String>data=new HashMap<String,String>();
        SharedPreferences sp=mContext.getSharedPreferences("mysp", Context.MODE_PRIVATE);
        data.put("username",sp.getString("username",""));
        data.put("passwd",sp.getString("passwd",""));
        return data;
        }
        }
