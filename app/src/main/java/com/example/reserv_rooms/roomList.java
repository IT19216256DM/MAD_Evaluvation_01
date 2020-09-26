package com.example.reserv_rooms;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class roomList extends ArrayAdapter<roomDet>{

    private Activity context;
    private List<roomDet> listRoom;

    public roomList(Activity context, List<roomDet> listRoom){
        super(context, R.layout.room_details_ret_list);
        this.context = context;
        this.listRoom = listRoom;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.room_details_ret_list, null, true);

        TextView txtType = (TextView) listViewItem.findViewById(R.id.txtType);
        TextView txtNo = (TextView) listViewItem.findViewById(R.id.txtNo);
        TextView txtDet = (TextView) listViewItem.findViewById(R.id.txtDet);
        TextView txtPrice = (TextView) listViewItem.findViewById(R.id.txtPrice);
        TextView txtSp = (TextView) listViewItem.findViewById(R.id.txtSp);
        TextView txtSports = (TextView) listViewItem.findViewById(R.id.txtSports);
        TextView txtRef = (TextView) listViewItem.findViewById(R.id.txtRef);
        TextView txtBoat = (TextView) listViewItem.findViewById(R.id.txtBoat);
        TextView txtSight = (TextView) listViewItem.findViewById(R.id.txtSight);

        roomDet detRoom = listRoom.get(position);

        txtType.setText(detRoom.getType());
        txtNo.setText(detRoom.getNo());
        txtDet.setText(detRoom.getDes());
        txtPrice.setText(detRoom.getPrice());
        txtSp.setText(detRoom.getSp());
        txtSports.setText(detRoom.getSports());
        txtBoat.setText(detRoom.getBoat());
        txtRef.setText(detRoom.getRef());
        txtSight.setText(detRoom.getSight());

        return listViewItem;


    }
}
