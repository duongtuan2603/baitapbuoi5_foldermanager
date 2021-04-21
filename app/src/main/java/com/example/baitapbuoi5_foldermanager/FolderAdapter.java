package com.example.baitapbuoi5_foldermanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.ViewHolder> {
    List<Folder> mFolders;
    Context mContext;

    public FolderAdapter(List<Folder> mFolders, Context mContext) {
        this.mFolders = mFolders;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View folderview = inflater.inflate(R.layout.layout_eachrow,parent,false);
        return new ViewHolder(folderview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Folder folder = mFolders.get(position);
        holder.eachfoldername.setText(folder.getFoldername());
        holder.position = position;
    }

    @Override
    public int getItemCount() {
        return mFolders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView eachfoldername;
        ImageButton eachfolderedit;
        ImageButton eachfolderdelete;
        int position;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eachfoldername = itemView.findViewById(R.id.txteachfoldername);
            eachfolderedit = itemView.findViewById(R.id.btneachfolderedit);
            eachfolderdelete = itemView.findViewById(R.id.btneachfolderdelete);

            eachfolderedit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        eachfoldername.setText("Untitled folder");
                }
            });

            eachfolderdelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mFolders.remove(position);
                    notifyItemRemoved(position);
                }
            });
        }


    }
}
