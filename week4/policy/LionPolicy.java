package policy;

public class LionPolicy implements SubmitPolicy {

  @Override
  public boolean canSubmit() {
    return true;
  }
}