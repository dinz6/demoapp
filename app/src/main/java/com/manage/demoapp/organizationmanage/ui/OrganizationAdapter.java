package com.manage.demoapp.organizationmanage.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.manage.demoapp.R;
import com.manage.demoapp.organizationmanage.model.Organization;

import java.util.List;

/**
 * Create by peter
 * Date 2018-12-28  19:48
 * Description:
 */
public class OrganizationAdapter extends RecyclerView.Adapter<OrganizationAdapter.ViewHolder> {
    private List<Organization> list;
    private Context context;
    private LayoutInflater inflater;
    private PickPictureListener listener;

    public OrganizationAdapter(List<Organization> list, Context context,PickPictureListener listener) {
        this.list = list;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {
        View view = inflater.inflate(R.layout.organization_item_layout, viewGroup, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Organization org = list.get(position);

        holder.org_name.setText(org.getName());
        holder.organization_id.setText(org.getId());
        holder.organization_type.setText(org.getType().getValue());
        holder.price.setText(String.valueOf(org.getPrice()));
        holder.organization_stars.setText(String.valueOf(org.getAssessmentStars()));
        holder.organization_beds.setText(String.valueOf(org.getNumBeds()));
        holder.organization_occupancies.setText(String.valueOf(org.getNumOccupancies()));
        holder.organization_idle.setText(String.valueOf(org.getIdleBeds()));
        holder.organization_manager.setText(org.getManager());
        holder.organization_phone.setText(org.getContactNumber());
        holder.organization_address.setText(org.getAddress());
        holder.btn_edit.setOnClickListener(v -> listener.doEdit(position));
        holder.btn_delete.setOnClickListener(v -> listener.doDelete(position));
        holder.btn_star.setOnClickListener(v -> listener.doGrade(position));
        holder.btn_upload.setOnClickListener(v -> listener.doPicker(position));
        holder.itemView.setOnClickListener(v -> listener.doItemViewClick(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView org_name;
        TextView organization_id;
        TextView organization_type;
        TextView price;
        TextView organization_stars;
        TextView organization_beds;
        TextView organization_occupancies;
        TextView organization_idle;
        TextView organization_manager;
        TextView organization_phone;
        TextView organization_address;
        BootstrapButton btn_edit;
        BootstrapButton btn_delete;
        BootstrapButton btn_star;
        BootstrapButton btn_upload;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            org_name = itemView.findViewById(R.id.org_name);
            organization_id = itemView.findViewById(R.id.organization_id);
            organization_type = itemView.findViewById(R.id.organization_type);
            price = itemView.findViewById(R.id.price);
            organization_stars = itemView.findViewById(R.id.organization_stars);
            organization_beds = itemView.findViewById(R.id.organization_beds);
            organization_occupancies = itemView.findViewById(R.id.organization_occupancies);
            organization_idle = itemView.findViewById(R.id.organization_idle);
            organization_manager = itemView.findViewById(R.id.organization_manager);
            organization_phone = itemView.findViewById(R.id.organization_phone);
            organization_address = itemView.findViewById(R.id.organization_address);
            btn_edit = itemView.findViewById(R.id.btn_edit);
            btn_delete = itemView.findViewById(R.id.btn_delete);
            btn_star = itemView.findViewById(R.id.btn_star);
            btn_upload = itemView.findViewById(R.id.btn_upload);
        }
    }

    public   interface PickPictureListener {
        void doPicker(int index);
        void doDelete(int index);
        void doEdit(int index);
        void doGrade(int index);

        void doItemViewClick(int position);
    }

}
