package model.dao;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "skill")
public class SkillDao {
    private long skillId;
    private String language;
    private String level;
    private Set<DeveloperDao> developers;


    public SkillDao(String language, String level) {
        this.language = language;
        this.level = level;
    }

    public SkillDao() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getSkillId() {
        return skillId;
    }
    @Column(name = "language")
    public String getLanguage() {
        return language;
    }
    @Column(name = "level")
    public String getLevel() {
        return level;
    }
    @ManyToMany(mappedBy = "skills")
    public Set<DeveloperDao> getDevelopers() {
        return developers;
    }

    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }


    public void setLanguage(String language) {
        this.language = language;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setDevelopers(Set<DeveloperDao> developers) {
        this.developers = developers;
    }
}

