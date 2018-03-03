package tfsandroid.tinkoff.ru.homework_3_fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DocumentFragment extends Fragment {

    public static final String DOCUMENT_TEXT = "documentText";

    public static DocumentFragment newInstance(String documentText) {
        Bundle args = new Bundle();
        args.putString(DOCUMENT_TEXT, documentText);
        DocumentFragment fragment = new DocumentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_document, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView documentText = view.findViewById(R.id.documentText);
        documentText.setText(getArguments().getString(DOCUMENT_TEXT));
    }
}
