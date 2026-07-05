# COREX - ПОЛНОЕ РУКОВОДСТВО

## ЧТО ТАКОЕ COREX?

`CoreX` — это язык, который транспилируется в C++. Ты пишешь код на CoreX, он превращается в C++, а g++ компилирует его в бинарник.
ТВОЙ КОД (.cox) → COREX → C++ КОД → g++ → ГОТОВАЯ ПРОГРАММА


**Главная фишка:** CoreX обрабатывает только свои команды (`import`, `use`, `Sys.`). Весь остальной C++ код проходит насквозь без изменений! Можно смешивать CoreX и C++ как угодно!

---

## КАК НАЧАТЬ

### Что нужно:
- Java 17 или новее
- g++

## META программирования
Во время компиляции кода вы можете выполнять конкретные команды, примеру:
meta.prinln Во время компиляции
meta.var a = 10
meta.println a
И это будет выводиться и выполняться только во время компиляции но на сам код при запуске не влияет !

Вот все функции
Все добавленные meta-функции (одна команда на строку):

Математические:

meta.sub x y - вычитание
meta.mul x y - умножение
meta.div x y - деление
meta.mod x y - остаток
meta.pow x y - степень
meta.sqrt x - корень
meta.abs x - модуль
meta.min a b c... - минимум
meta.max a b c... - максимум
meta.avg a b c... - среднее
meta.round x n - округление
meta.random min max - случайное число
Строковые:

meta.len x - длина строки
meta.upper x - верхний регистр
meta.lower x - нижний регистр
meta.trim x - обрезка пробелов
meta.replace x old new - замена
meta.contains x sub - содержит
meta.starts x pref - начинается с
meta.ends x suff - заканчивается на
meta.index x sub - индекс подстроки
meta.substring x s e - подстрока
meta.reverse x - разворот
meta.repeat x n - повтор
Логика и управление:

meta.if x > y ? yes : no - тернарный оператор
meta.counter init step - счетчик
meta.next - инкремент
meta.reset - сброс
Переменные:

meta.set x=val - установка
meta.copy src dest - копирование
meta.swap x y - обмен
meta.delete x - удаление
meta.clear - очистка всех
meta.type x - тип значения
meta.list - список переменных
meta.listall - все переменные
Системные:

meta.time - текущее время

### Первая программа (`hello.cox`):
use Sys
use name std

_main() {
    Sys.println("Привет, мир!")
    return 0
}
Запуск:

java -jar CoreX.jar hello.cox hello.cpp --compilation hello --run
СИНТАКСИС

## Импорты из других любых C++ или COX файлов
Для начало вам предсвтоит понять что такое plus
## оператор let и зачем он нужен
Для начало стоило бы начать с обычных переменных они обьявляются так
тип имя = значения;
пример:
int a = 10;

А let переменные это защищенные переменные их суть в том что если в коде не используется перменная обьявленная через let то компилятор будет ругаться, и еще будет ругаться если длина имени переменной меньше двух! Вот реальный пример
_main() {
    let int a = 10;
    a = 20;
}

Компилятор выдаст ошибку ведь имя `a` слишком короткое а если написать так:
_main() {
    let int numver = 10;
    a = 30;
}
То тогда все скомпилируется отклично !
let нужно использовать в больших проектов или в нагруженом beckend где одна лишняя перемення играет погоду!

## plus
Удобный `инструмент/помошник` который может импортировать либо переменные либо целый файл
## Примеры
plus data.cpp
И теперь все что было в data.cpp импортируется в файл в котором вы написали приотом импортируется вообще все 
Также если у вас есть какая то переменная которая везде одинковая то вот что я советую
## Файлы plus
Создайте файл .plus 
Там пропишите переменную пример
String text = "Hello";
## Как импортировать ?
Вы должный написать
plus var файл.plus text
И теперь у вас импортируется это переменную и вы можете использовать ее !

## Игры 
Да можно писать быстро игры используя SFML
вот пример реального кода
#include <SFML/Graphics.hpp>
int main() {
    sf::RenderWindow window(sf::VideoMode({800, 600}), "SFML Game");


    while (window.isOpen()) {
        if (auto event = window.pollEvent()) {
            if (event->is<sf::Event::Closed>()) {
                window.close();
            }
        }
        window.clear(sf::Color::Black);
        window.display();
    }
    return 0;
}
А вот команды для компиляции
coreX main.cox main.cpp --compilation main "-std=c++17 -I/opt/homebrew/include -L/opt/homebrew/lib -lsfml-graphics -lsfml-window -lsfml-system"
Также если вы на MacOS советую прописать обязательно
brew install sfml 
Linux
sudo apt install sfml или Pacman -S sfml
Windwos
Вам нужно прописать в коде
use install sfml


## Функции

Функции начинаются с _. CoreX убирает _ и добавляет int:

_main() { return 0 }
_foo() { return 0 }
Превратится в:

int main() { return 0; }
int foo() { return 0; }
IMPORT (импорт C++ библиотек)

Команда	Результат
import <iostream>	#include <iostream>
import <vector>	#include <vector>
import <string>	#include <string>
import <map>	#include <map>
import <fstream>	#include <fstream>
import <algorithm>	#include <algorithm>
import <cmath>	#include <cmath>
import <memory>	#include <memory>
import <thread>	#include <thread>
USE (помощник)

Системные:

Команда	Результат
use Sys	#include <iostream>
use name std	using namespace std;
ANSI-цвета:

Команда	Создаёт
use create red	std::string red = "\033[31m";
use create green	std::string green = "\033[32m";
use create yellow	std::string yellow = "\033[33m";
use create blue	std::string blue = "\033[34m";
use create magenta	std::string magenta = "\033[35m";
use create reset	std::string reset = "\033[0m";
Установка библиотек:

Команда	Результат
use install crow	Клонирует Crow с GitHub
SYS (системные команды)

Команда	C++ код	Описание
Sys.println("текст")	std::cout << "текст" << std::endl;	Вывод с новой строкой
Sys.print("текст")	std::cout << "текст";	Вывод без новой строки
Sys.input(переменная)	std::cin >> переменная;	Ввод данных
Sys.exit()	std::exit(0);	Выход из программы
Sys.del(указатель)	delete указатель;	Удаление указателя

## Также имеет пакет скачивания виде use clone
Вам нужно написать use clone сыллка_на_гитхаб
И тогда в папке проекта появится то что вы скачивали !

## ПОЛНЫЕ ПРИМЕРЫ

Пример 1: Ввод и вывод

import <string>
use Sys
use name std

_main() {
    string name
    int age
    
    Sys.print("Введите имя: ")
    Sys.input(name)
    
    Sys.print("Введите возраст: ")
    Sys.input(age)
    
    Sys.print("Привет, ")
    Sys.print(name)
    Sys.print("! Тебе ")
    Sys.print(age)
    Sys.println(" лет!")
    
    return 0
}
Пример 2: Переменные и if/else

use Sys
use name std

_main() {
    int age = 18
    
    if (age >= 18) {
        Sys.println("Ты совершеннолетний!")
    } else {
        Sys.println("Ты ещё маленький!")
    }
    
    return 0
}
Пример 3: Циклы for и while

use Sys
use name std

_main() {
    for (int i = 0; i < 5; i++) {
        Sys.print("Итерация: ")
        Sys.println(i)
    }
    
    int count = 3
    while (count > 0) {
        Sys.println("Обратный отсчёт!")
        count = count - 1
    }
    
    return 0
}
Пример 4: Векторы


import <vector>
use Sys
use name std

_main() {
    vector<int> numbers
    numbers.push_back(10)
    numbers.push_back(20)
    numbers.push_back(30)
    
    for (int i = 0; i < numbers.size(); i++) {
        Sys.print("Элемент: ")
        Sys.println(numbers[i])
    }
    
    return 0
}
Пример 5: Строки


import <string>
use Sys
use name std

_main() {
    string name = "CoreX"
    string greeting = "Привет, " + name + "!"
    
    Sys.println(greeting)
    Sys.print("Длина имени: ")
    Sys.println(name.length())
    
    return 0
}
Пример 6: Указатели и память

use Sys
use name std

_main() {
    int* ptr = new int(42)
    
    Sys.print("Значение: ")
    Sys.println(*ptr)
    
    Sys.del(ptr)
    Sys.println("Память очищена!")
    
    return 0
}
Пример 7: Цветной вывод с логикой

use Sys
use name std
use create red
use create green
use create reset

_main() {
    int score = 85
    
    if (score >= 90) {
        Sys.println(green + "Отлично! Оценка: A" + reset)
    } else if (score >= 80) {
        Sys.println(green + "Хорошо! Оценка: B" + reset)
    } else if (score >= 70) {
        Sys.println(red + "Удовлетворительно! Оценка: C" + reset)
    } else {
        Sys.println(red + "Плохо! Нужно лучше!" + reset)
    }
    
    return 0
}
Пример 8: Функции


use Sys
use name std

_sum(int a, int b) {
    return a + b
}

_main() {
    int result = sum(5, 3)
    Sys.print("Сумма: ")
    Sys.println(result)
    return 0
}
Пример 9: Классы


import <string>
use Sys
use name std

class Person {
public:
    string name
    int age
    
    void introduce() {
        Sys.print("Привет, я ")
        Sys.print(name)
        Sys.print(", мне ")
        Sys.print(age)
        Sys.println(" лет!")
    }
}

_main() {
    Person p
    p.name = "Карен"
    p.age = 25
    p.introduce()
    return 0
}
Пример 10: switch/case


use Sys
use name std

_main() {
    int choice = 2
    
    switch (choice) {
        case 1:
            Sys.println("Выбран первый вариант")
            break
        case 2:
            Sys.println("Выбран второй вариант")
            break
        default:
            Sys.println("Неизвестный выбор")
    }
    
    return 0
}
Пример 11: ПОЛНАЯ ПРОГРАММА СО ВСЕМИ ФИЧАМИ


import <vector>
import <string>
import <algorithm>
use Sys
use name std
use create red
use create green
use create yellow
use create blue
use create magenta
use create reset

_isEven(int n) {
    return n % 2 == 0
}

_main() {
    Sys.println(blue + "===== COREX DEMO =====" + reset)
    Sys.println("")
    
    vector<int> numbers
    for (int i = 1; i <= 5; i++) {
        numbers.push_back(i * 10)
    }
    
    Sys.println(green + "Чётные числа:" + reset)
    for (int i = 0; i < numbers.size(); i++) {
        if (isEven(numbers[i])) {
            Sys.print("  - ")
            Sys.println(numbers[i])
        }
    }
    
    int score = 85
    Sys.println("")
    Sys.print(yellow + "Результат: " + reset)
    
    if (score >= 90) {
        Sys.println(green + "ОТЛИЧНО!" + reset)
    } else if (score >= 80) {
        Sys.println(blue + "ХОРОШО!" + reset)
    } else {
        Sys.println(red + "НУЖНО ЛУЧШЕ!" + reset)
    }
    
    Sys.println("")
    Sys.println(magenta + "Программа завершена!" + reset)
    
    return 0
}
ЗАПУСК ПРОГРАММ

Команда	Результат
java -jar CoreX.jar in.cox out.cpp	Только C++ файл
... --compilation app	+ скомпилирует в app
... --run	+ сразу запустит
... "-O2 -lm"	+ флаги для g++
Примеры запуска:

# Только транспиляция
java -jar CoreX.jar main.cox main.cpp

# Транспиляция + компиляция
java -jar CoreX.jar main.cox main.cpp --compilation myapp

# Транспиляция + компиляция + запуск
java -jar CoreX.jar main.cox main.cpp --compilation myapp --run

# С флагами
java -jar CoreX.jar main.cox main.cpp --compilation myapp "-O2 -lm" --run
ВАЖНЫЕ ПРАВИЛА

Функции начинаются с _
cox
_main() {
    return 0
}
После цветов всегда reset

Sys.println(red + "текст" + reset)     // ПРАВИЛЬНО
Sys.println(red + "текст")             // НЕПРАВИЛЬНО
Строки в двойных кавычках

Sys.println("Правильно")
Любой C++ код работает!

_main() {
    int x = 10
    int y = 20
    int z = x + y
    
    for (int i = 0; i < 10; i++) {
        Sys.println(i)
    }
    
    return 0
}
CoreX — язык, который помогает, а не мешает! 🔥
