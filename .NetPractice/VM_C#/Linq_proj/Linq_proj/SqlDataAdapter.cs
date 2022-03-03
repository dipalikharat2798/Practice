using System;
using System.Data;

namespace Linq_proj
{
    internal class SqlDataAdapter
    {
        private string v;
        private SqlConnection conn;

        public SqlDataAdapter(string v, SqlConnection conn)
        {
            this.v = v;
            this.conn = conn;
        }

        internal void Fill(DataSet ds, string v)
        {
            throw new NotImplementedException();
        }
    }
}