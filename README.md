# Ficha de Laboratório #10 - Introdução aos Testes Unitários em Java

## Preparação

O projeto inclui:

- `ClassGroup`
- `Student`
- Estrutura inicial em `src/test/java`

---

# Contexto

Pretende-se desenvolver um conjunto completo de **testes unitários** para a classe `ClassGroup`.  
Todos os testes devem seguir boas práticas:

### ✔ Regras obrigatórias
- Deve criar uma classe de teste `GrouClassTest` na diretoria `test`.
- **Cada caso de teste deve ser implementado num método de teste separado.**
- **Deve existir um método `@BeforeEach` chamado `setup()`**, responsável por:
    - Criar uma turma (`ClassGroup`)
    - Criar pelo menos **8 estudantes**
    - Adicioná‑los à turma antes de cada teste

- Deve ter como método de `setup` o seguinte

```java
private ClassGroup group;

@BeforeEach
void setup() {
    group = new ClassGroup("POO");

    group.add(new Student("Ana", 12345, 12.5, 3));
    group.add(new Student("Bruno", 54321, 15.0, 5));
    group.add(new Student("Carla", 11111, 9.5, 2));
    group.add(new Student("Duarte", 22222, 18.0, 4));
    group.add(new Student("Eva", 33333, 17.0, 5));
    group.add(new Student("Filipe", 44444, 10.0, 1));
    group.add(new Student("Gonçalo", 55555, 8.0, 2));
    group.add(new Student("Helena", 66666, 19.0, 3));
}
```

---

# Nível 1 – Testes para Remoção com Iterator

Método a testar:

```java
public void removeByEnrollments(int x)
```

### Casos obrigatórios (cada um num método de teste separado)

1. Remove estudantes com inscrições **superiores** a x
2. Não remove estudantes com inscrições **iguais** a x
3. Não remove estudantes com inscrições **inferiores** a x
4. Nenhum estudante removido (caso limite)
5. Todos os estudantes removidos (caso extremo)
6. Turma vazia (criar turma vazia dentro do teste)

---

# Nível 2 – Testes para Contagem e Ordenação

## 1. Método:

```java
public long countGrades(double value)
```

### Casos obrigatórios

1. Conta corretamente estudantes com nota superior ao valor
2. Nenhum estudante acima do valor
3. Todos os estudantes acima do valor
4. Notas iguais ao valor **não contam**
5. Turma vazia devolve 0
6. **Lança IllegalArgumentException quando value < 0**
    - Deve verificar a mensagem `"value negative"`

---

## 2. Método:

```java
public List<Student> sortByName()
```

### Casos obrigatórios

1. Ordena corretamente por nome
2. Nomes repetidos mantêm ordem estável
3. A lista original **não é modificada**
4. Turma vazia devolve lista vazia

---

# Nível 3 – Testes com Programação Funcional

## 1. Método:

```java
public List<Student> top3()
```

### Casos obrigatórios

1. Devolve exatamente 3 estudantes quando existem ≥ 3
2. Devolve apenas os existentes quando existem < 3
3. Ordem correta (notas decrescentes)
4. Notas iguais mantêm ordem estável
5. Turma vazia devolve lista vazia

---

## 2. Método:

```java
public double avgGrade()
```

### Casos obrigatórios

1. Média correta com várias notas
2. Média correta com notas decimais
3. Turma vazia devolve 0.0
4. Média de um único estudante

---

# Nível 4 – Testes de Predicados e Transformações

## 1. Método:

```java
public boolean hasLowerGrade(double value)
```

### Casos obrigatórios

1. Existe estudante com nota inferior ao valor
2. Nenhum estudante com nota inferior ao valor
3. Todos os estudantes com nota inferior ao valor
4. Turma vazia devolve false

---

## 2. Método:

```java
public boolean validNumbers()
```

### Casos obrigatórios

1. Todos os números são válidos (5 dígitos)
2. Pelo menos um número inválido
3. Todos os números inválidos
4. Turma vazia devolve true

---

## 3. Método:

```java
public List<String> namesNumberOfEnrollments(int number)
```

### Casos obrigatórios

1. Devolve apenas estudantes com o número de inscrições indicado
2. Nomes devolvidos em MAIÚSCULAS
3. Lista devolvida ordenada alfabeticamente
4. Nenhum estudante com esse número devolve lista vazia
5. Vários estudantes com esse número devolvem lista correta

---

# Nível 5 – Teste de Integração

Criar um teste que:

1. Usa o `setup()` para criar a turma
2. Invoca **todos os métodos** da classe `ClassGroup`
3. Verifica que o estado final da turma é consistente
4. Cada verificação deve ser feita com asserts separados  

