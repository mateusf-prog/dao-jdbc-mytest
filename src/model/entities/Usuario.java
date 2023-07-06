package model.entities;
import java.util.Objects;

public class Usuario {

    private String name;
    private Integer age;
    private Integer id;

    public Usuario(){
    }

    public Usuario(String name, Integer age, Integer id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(name, usuario.name) && Objects.equals(age, usuario.age) && Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, id);
    }


    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", age='" + getAge() + "'" +
            ", id='" + getId() + "'" +
            "}";
    }

}
