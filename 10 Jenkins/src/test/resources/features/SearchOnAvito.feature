# language: ru
@1
Функционал: Поиск на авито

  Структура сценария: Найдем самые дорогие принтеры на авито
    Пусть открыт ресурс авито
    И в выпадающем списке категорий выбрана Оргтехника и расходники
    И в поле поиска введено значение <product>
    Тогда кликнуть по выпадающему списку региона
    Тогда в поле регион введено значение <city>
    И нажата кнопка показать объявления
    Тогда открылась страница результаты по запросу <product>
    И активирован чекбокс только с фотографией
    И в выпадающем списке сортировка выбрано значение Дороже
    И в консоль выведено значение названия и цены <count> первых товаров
    Примеры:
      | product  | city        | count |
      | принтер  | Владивосток | 5     |
