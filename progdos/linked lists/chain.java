public class chain<T>
{
    protected T info;
    protected chain<T> before = null;
    protected chain<T> after = null;
    
    public chain(T info)
    { this.info = info; }
    
    public T info()
    { return this.info; }
    public void info(T info)
    { this.info = info; }
    
    public chain<T> before()
    { return this.before; }
    public void before(chain<T> before)
    { this.before = before; }
    
    public chain<T> after()
    { return this.after; }
    public void after(chain<T> after)
    { this.after = after; }
}