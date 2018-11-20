-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Ноя 20 2018 г., 11:14
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
  `Login_Name` tinytext CHARACTER SET utf8 NOT NULL,
  `Cur_Balance` int(10) UNSIGNED NOT NULL,
  `Gen_Income` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Структура таблицы `balance`
--

CREATE TABLE `balance` (
  `ID` int(10) UNSIGNED NOT NULL,
  `Type` tinyint(1) NOT NULL,
  `Sum` mediumint(8) UNSIGNED NOT NULL,
  `Cur_Balance` mediumint(8) UNSIGNED NOT NULL,
  `Gen_Income` mediumint(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Структура таблицы `bet_history`
--

CREATE TABLE `bet_history` (
  `Date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ID` smallint(6) UNSIGNED NOT NULL,
  `Bet` text CHARACTER SET utf8,
  `Total_Strake` mediumint(9) DEFAULT NULL,
  `Return` int(11) DEFAULT NULL,
  `Odds` mediumint(9) DEFAULT NULL,
  `Status` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Дамп данных таблицы `bet_history`
--

INSERT INTO `bet_history` (`Date`, `ID`, `Bet`, `Total_Strake`, `Return`, `Odds`, `Status`) VALUES
('2018-11-16 11:46:49', 2, 'Viktoria Plzen To Score - Yes \r\nViktoria Plzen vs Real Madrid', 55, 0, 2, 0);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `balance`
--
ALTER TABLE `balance`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `bet_history`
--
ALTER TABLE `bet_history`
  ADD UNIQUE KEY `Number` (`ID`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `accounts`
--
ALTER TABLE `accounts`
  MODIFY `ID` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `balance`
--
ALTER TABLE `balance`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `bet_history`
--
ALTER TABLE `bet_history`
  MODIFY `ID` smallint(6) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
