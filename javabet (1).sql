-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Ноя 28 2018 г., 06:54
-- Версия сервера: 10.1.30-MariaDB
-- Версия PHP: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `javabet`
--

-- --------------------------------------------------------

--
-- Структура таблицы `accounts`
--

CREATE TABLE `accounts` (
  `ID` smallint(5) UNSIGNED NOT NULL,
  `Login_Name` tinytext CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Дамп данных таблицы `accounts`
--

INSERT INTO `accounts` (`ID`, `Login_Name`) VALUES
(11, 'Bobur');

-- --------------------------------------------------------

--
-- Структура таблицы `bet_history`
--

CREATE TABLE `bet_history` (
  `Date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ID` smallint(6) UNSIGNED NOT NULL,
  `account_id` smallint(5) UNSIGNED NOT NULL,
  `Bet` text CHARACTER SET utf8,
  `Total_Strake` double DEFAULT NULL,
  `Benefit` double DEFAULT NULL,
  `Odds` double DEFAULT NULL,
  `Status` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Дамп данных таблицы `bet_history`
--

INSERT INTO `bet_history` (`Date`, `ID`, `account_id`, `Bet`, `Total_Strake`, `Benefit`, `Odds`, `Status`) VALUES
('2018-11-27 16:17:03', 1, 11, 'Real Madrid - Barcelona', 500, 0, 3.2, 0);

-- --------------------------------------------------------

--
-- Структура таблицы `transactions`
--

CREATE TABLE `transactions` (
  `ID` int(10) UNSIGNED NOT NULL,
  `account_id` smallint(11) UNSIGNED NOT NULL,
  `Type_bet` tinyint(1) NOT NULL,
  `Type_withdrawal` tinyint(1) NOT NULL,
  `Sum` double UNSIGNED NOT NULL,
  `Cur_Balance` double UNSIGNED NOT NULL,
  `Gen_Income` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Дамп данных таблицы `transactions`
--

INSERT INTO `transactions` (`ID`, `account_id`, `Type_bet`, `Type_withdrawal`, `Sum`, `Cur_Balance`, `Gen_Income`) VALUES
(9, 11, 0, 0, 500, 500, -500),
(10, 11, 1, 1, 500, 0, -1000);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `bet_history`
--
ALTER TABLE `bet_history`
  ADD UNIQUE KEY `Number` (`ID`),
  ADD KEY `account_id` (`account_id`);

--
-- Индексы таблицы `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `account_id` (`account_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `accounts`
--
ALTER TABLE `accounts`
  MODIFY `ID` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT для таблицы `bet_history`
--
ALTER TABLE `bet_history`
  MODIFY `ID` smallint(6) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT для таблицы `transactions`
--
ALTER TABLE `transactions`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `bet_history`
--
ALTER TABLE `bet_history`
  ADD CONSTRAINT `bet_history_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
