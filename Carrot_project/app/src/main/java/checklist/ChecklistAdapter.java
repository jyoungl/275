package checklist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.carrot_project.R;

import java.util.ArrayList;

public class ChecklistAdapter extends BaseAdapter {

    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();

    public ChecklistAdapter() {

    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.perchecklist_listview_item, parent, false);
        }
        TextView checklistView = (TextView) convertView.findViewById(R.id.text);
        CheckBox checkboxView = (CheckBox) convertView.findViewById(R.id.box);

        ListViewItem listViewItem = listViewItemList.get(position);

        checklistView.setText(listViewItem.getCheckList());
        //checkboxView.setChecked(listViewItem.getCheck());

        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //아이템 데이터 추가 함수
    public void addItem(String TEXT){
        ListViewItem item=new ListViewItem();

        item.setChecklist(TEXT);
        //item.setCheck(BOX);

        listViewItemList.add(item);
    }

}
