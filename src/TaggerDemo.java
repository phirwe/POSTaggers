import edu.stanford.nlp.util.logging.Redwood;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import edu.stanford.nlp.ling.SentenceUtils;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class TaggerDemo  {

  /** A logger for this class */
  private static Redwood.RedwoodChannels log = Redwood.channels(TaggerDemo.class);

  private TaggerDemo() {}

  public static void main(String[] args) throws Exception {
    MaxentTagger tagger = new MaxentTagger("english-bidirectional-distsim.tagger");
    String output = "";
    List<List<HasWord>> sentences = MaxentTagger.tokenizeText(new BufferedReader(new FileReader("brown_nolines.txt")));
    for (List<HasWord> sentence : sentences) {
      List<TaggedWord> tSentence = tagger.tagSentence(sentence);
      output += SentenceUtils.listToString(tSentence, false);
    }
    BufferedWriter writer = new BufferedWriter(new FileWriter("brown_tagged.txt"));
    writer.write(output);
    writer.close();
  }

}
