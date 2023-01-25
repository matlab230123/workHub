
USE SAKILA;
Select * from actor where first_name = 'Scarlett';
Select * from actor where last_name = 'Johansson';
Select count(distinct last_name) from actor;
select last_name, count(last_name) as appear from actor group by last_name having appear=1;
select last_name, count(last_name) as appear from actor group by last_name having appear>1;
select a.actor_id, a.first_name, a.last_name, count(a.actor_id) as appear from film_actor fa inner join actor a on a.actor_id = fa.actor_id
group by fa.actor_id order by appear desc limit 1;
select f.title, s.store_id from film f inner join inventory i on f.film_id = i.film_id inner join store s on i.store_id = s.store_id where s.store_id=1;

select f.title, s.store_id, i.inventory_id
from inventory i inner join store s on i.store_id = s.store_id inner join film f on i.film_id = f.film_id
where f.title = 'Academy Dinosaur' and s.store_id = 1;


insert into rental (rental_date, inventory_id, customer_id, staff_id)
values (NOW(), 1, 1, 1);

SELECT c.last_name, c.first_name, max(r.rental_date) as "latest" FROM customer c INNER JOIN rental r
     ON c.customer_id = r.customer_id GROUP BY c.customer_id ORDER BY latest desc limit 1;

select avg(length) from film;

select category.name, avg(film.length) from film join film_category using (film_id) join category using (category_id)
group by category.name order by avg(length) desc;

select category.name, avg(film.length) from film join film_category using(film_id) join category using (category_id)
group by category.name having avg(film.length) > (select avg(length) from film);



SELECT * from staff;
select * from customer;
select * from rental;
select * from inventory;
select * from film;
select * from film_category;
select * from store;
select * from category;
select * from film_text;