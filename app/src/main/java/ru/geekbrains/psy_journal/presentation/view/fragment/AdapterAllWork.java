package ru.geekbrains.psy_journal.presentation.view.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.geekbrains.psy_journal.R;
import ru.geekbrains.psy_journal.presentation.presenter.IRecyclerAllWorkPresenter;
import ru.geekbrains.psy_journal.presentation.presenter.view_ui.IViewHolder;

public class AdapterAllWork extends RecyclerView.Adapter<AdapterAllWork.ViewHolder> {

    private final IRecyclerAllWorkPresenter presenter;

    AdapterAllWork(IRecyclerAllWorkPresenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_all_work, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.position = position;
        presenter.bindView(holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getItemCount();
    }

    public void delete(int adapterPosition) {
        notifyItemRemoved(adapterPosition);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements IViewHolder, View.OnClickListener {

        @BindView(R.id.date_layout)
        TextView dateLayout;

        @BindView(R.id.theme)
        TextView themeLayout;

        private int position = 0;

        private ViewHolder(final View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
        }

        @Override
        public void setWork(String date, String theme) {
            dateLayout.setText(date);
            themeLayout.setText(theme);
        }

        @Override
        public int getPos() {
            return position;
        }

        @Override
        public void onClick(View v) {
            presenter.onClickUpdate(this);
        }
    }
}
