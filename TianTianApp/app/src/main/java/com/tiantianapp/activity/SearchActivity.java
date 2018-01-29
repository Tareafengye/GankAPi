package com.tiantianapp.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.tiantianapp.R;
import com.tiantianapp.adapter.SearchAdpater;
import com.tiantianapp.base.BaseActivity;
import com.tiantianapp.dbhelper.DbHelper;
import com.tiantianapp.model.CoordinateAlterSample;
import com.tiantianapp.model.GankUrlBean;
import com.tiantianapp.rxjava.DefaultObserver;
import com.tiantianapp.rxjava.IdeaApi;
import com.tiantianapp.util.ByAlert;
import com.tiantianapp.util.LogUtil;
import com.tiantianapp.weight.AddedFlowLayout;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SearchActivity extends BaseActivity {
    private EditText editText;
    private TextView tv_save;
    private SearchAdpater adapter;
    private ListView item_list;
    private List<CoordinateAlterSample> listview = new ArrayList<>();
    private DbHelper dbHelper = null;
    private static final String DB = "Test";
    public static final String TabOther = "TabOther";
    private AddedFlowLayout search_page_flowlayout;
    private List<String> dataList = new ArrayList<>();
    private TextView tvClear;//清空历史搜索
    private LinearLayout llt_search;
    private String[] name = {"菅纫姿", "范冰冰", "李冰冰", "刘亦菲", "斗破苍穹", "斗罗大陆"};
    private ImageView iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        dbHelper = new DbHelper(this, DB, null, 1);
        dbHelper.inItDb(dbHelper.getOther(TabOther));
        setBarColor(this, 112);
        updateList();
        getTag();
        getResult();
    }

    public void getResult() {
        IdeaApi.getApiService().getSeaerch("福利")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DefaultObserver<GankUrlBean>(this, false) {
                               @Override
                               public void onSuccess(GankUrlBean response) {
                                   LogUtil.d("responseSeaerch" + response.getResults().size());
                               }
                           }
                );
    }

    public void getTag() {
        dataList.clear();
        search_page_flowlayout.cancelAllSel();
        for (int i = 0; i < name.length; i++) {
            dataList.add(name[i] + "");
        }
        search_page_flowlayout.setDataList(dataList);
    }

    public void onInset(String name) {
        editText.setText("");
        editText.setHint("请输入搜索内容");
        int num = listview.size() + 1;
        ContentValues values = new ContentValues();
        values.put("id", num + "");
        values.put("name", name + "");
        dbHelper.insert(values, TabOther);
        updateList();
    }

    private void updateList() {
        try {
            listview.clear();
            listview = queryAll();
            LogUtil.d("adaerName:" + queryAll().size());
            adapter = new SearchAdpater(this, listview);
            item_list.setAdapter(adapter);
            adapter.setOnItemDeleteClickListener(new SearchAdpater.DeleteExpress() {
                @Override
                public void onDeleteExpress(int position, View view) {
                    updateList();
                    dbHelper.delete(listview.get(position).getId() + "", TabOther);
                    adapter.notifyDataSetChanged();
                    updateList();
                    LogUtil.d("onDeleteExpress" + listview.get(position).getId() + "");
                }
            });
            item_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    editText.setText(listview.get(position).getName() + "");
                }
            });
            adapter.notifyDataSetChanged();
            if (listview.size() == 0 || listview == null) {
                llt_search.setVisibility(View.GONE);
            } else {
                llt_search.setVisibility(View.VISIBLE);
            }

        } catch (Exception e) {
        }
    }

    /**
     * 查询数据库
     *
     * @return
     */
    public List<CoordinateAlterSample> queryAll() {
        List<CoordinateAlterSample> rst = new ArrayList<CoordinateAlterSample>();
        // 解析游标
        Cursor cursor = dbHelper.query(TabOther);
        CoordinateAlterSample persion = null;
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                persion = new CoordinateAlterSample();
                persion.id = cursor.getString(cursor.getColumnIndex("id"));
                persion.name = cursor.getString(cursor.getColumnIndex("name"));
                rst.add(persion);
                cursor.moveToNext();
            }
        }
        return rst;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.tv_save:
                String aa = editText.getText().toString().trim();
                if (TextUtils.isEmpty(aa)) {
                    ByAlert.alert("请输入搜索内容");
                    return;
                }
                onInset(aa);
                break;
            case R.id.tvClear:
                dbHelper.deleteAllRecords();
                updateList();
                break;
            case R.id.iv_back:
                finish();
                break;
        }

    }


}
