# Сортировка

Есть набор объектов Student. 

Задача:
* Представить объекты в виде таблицы
* Реализовать механизм сортировки таблицы по колонкам

## Коллекции в Java

* Вспомним ещё раз про ArrayList, как динамический массив объектов определённого типа.
* TreeMap - коллекция, в котрой объекты сохраняются в отсортированном порядке по возрастанию, каждому объекту соответствует уникальный ключ.

## ArrayList
[Документация](https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html)

Примеры.

Добавление объектов:
```Java
ArrayList<Student> students = new ArrayList<>();
students.add(new Student("Иванов Иван Иванович", 21, 403));
students.add(new Student("Абриков Алекс Петрович", 20, 303));
students.add(new Student("Петров Пётр Петрович", 18, 203));
```

Вывод объектов:

```Java
students.forEach(s -> System.out.printf("%s\t%d\t%d\n", s.getName(), s.getAge(), s.getGroupNumber()));
```
Результат:

```
Иванов Иван Иванович	21	403
Абриков Алекс Петрович	20	303
Петров Пётр Петрович	18	203
```

## TreeMap
[Документация](https://docs.oracle.com/javase/7/docs/api/java/util/TreeMap.html)

Примеры.

Добавление объектов:
```Java
Map<String, Student> studentsSortByName = new TreeMap<>();
students.forEach(s -> studentsSortByName.put(s.getName() + s.hashCode(), s));
```

Вывод объектов:

```Java
studentsSortByName.entrySet().forEach(s -> System.out.printf("%s\t%d\t%d\n",
                                            s.getValue().getName(),
                                            s.getValue().getAge(),
                                            s.getValue().getGroupNumber()));
```
Результат:

```
Абриков Алекс Петрович	20	303
Иванов Иван Иванович	21	403
Петров Пётр Петрович	18	203
```

Сортировка по возрасту в обратном порядке:

Добавление объектов:
```Java
Map<String, Student> studentsSortByAge = new TreeMap<>(Collections.reverseOrder());
students.forEach(s -> studentsSortByAge.put(s.getAge() + " " + s.hashCode(), s));
```

Вывод объектов:

```Java
studentsSortByAge.entrySet().forEach(s -> System.out.printf("%s\t%d\t%d\n",
                                        s.getValue().getName(),
                                        s.getValue().getAge(),
                                        s.getValue().getGroupNumber()));
```

Результат:

```
Иванов Иван Иванович	21	403
Абриков Алекс Петрович	20	303
Петров Пётр Петрович	18	203
```

## hashCode
[Документация](https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#hashCode())

---
hashCode - число, которое является хеш-кодом объекта.
