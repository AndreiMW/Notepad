/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

/**
 *
 * @author andre
 */
public class HighlightWorker extends SwingWorker<Boolean, Void> {

    private AFCTextArea myTextArea;
    private JTextField searchField;

    public HighlightWorker(AFCTextArea a, JTextField b) {

        this.myTextArea = a;
        this.searchField = b;

    }

    public void Highlight(JTextComponent textComp, String pattern) {

        removeHighlight(textComp);

        try {

            Highlighter highL = textComp.getHighlighter();
            Document doc = textComp.getDocument();
            String text = doc.getText(0, doc.getLength());
            Integer pos = 0;

            while ((pos = text.toUpperCase().indexOf(pattern.toUpperCase(), pos)) >= 0) {

                highL.addHighlight(pos, pos + pattern.length(), myHighlightPainter);
                pos += pattern.length();
            }

        } catch (Exception e) {

            System.out.println(e);
        }

    }

    class MyHighlightePainter extends DefaultHighlighter.DefaultHighlightPainter {

        public MyHighlightePainter(Color color) {
            super(color);
        }

    }

    Highlighter.HighlightPainter myHighlightPainter = new MyHighlightePainter(Color.pink);

    public void removeHighlight(JTextComponent textComp) {

        Highlighter highL = textComp.getHighlighter();
        Highlighter.Highlight[] highLights = highL.getHighlights();

        for (int i = 0; i < highLights.length; i++) {

            if (highLights[i].getPainter() instanceof MyHighlightePainter) {

                highL.removeHighlight(highLights[i]);

            }
        }

    }

    @Override
    protected Boolean doInBackground() throws Exception {

        Highlight(this.myTextArea.textArea, this.searchField.getText());

        return true;
    }

}
