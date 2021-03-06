import exceptions.UncheckedException;

import java.util.Objects;

public class NatureEffects {
    private String name;
    private SubjectType subjectType;

    public NatureEffects(String name) {
        this.name = name;
    }

    public NatureEffects(String name, SubjectType subjectType) {
        this.name = name;
        this.subjectType = subjectType;
    }

    public String getName() {
        return name;
    }

    public SubjectType getSubjectType() {
        if (subjectType == null)
            try {
                throw new UncheckedException("SubjectType для объекта не определён!");
            } catch (UncheckedException e) {
                e.printStackTrace();
                return SubjectType.NULL;
            }
        return subjectType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NatureEffects that = (NatureEffects) o;
        return Objects.equals(name, that.name) &&
                subjectType == that.subjectType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subjectType);
    }
}
