<?php
/**
 * Generate a random string, using a cryptographically secure 
 * pseudorandom number generator (random_int)
 * Visit: 
 * http://stackoverflow.com/questions/4356289/php-random-string-generator/31107425#31107425
 * for more info.
 *
 * For PHP 7, random_int is a PHP core function
 * For PHP 5.x, depends on https://github.com/paragonie/random_compat
 * 
 * @param int $length      How many characters do we want?
 * @param string $keyspace A string of all possible characters
 *                         to select from
 * @return string
 */
function random_str($length)
{
    /* this has been commented out as it calls a function inside the loop (random_int())
    random_int isnt part of the php core
     * $str = '';
    $max = mb_strlen($keyspace, '8bit') - 1;
    for ($i = 0; $i < $length; ++$i) {
        $str .= $keyspace[random_int(0, $max)];
    }
    return $str;*/

    $temp = substr(str_shuffle("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"), 0, $length);
    return $temp;
}